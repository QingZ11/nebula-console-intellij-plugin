package com.neueda.jetbrains.plugin.graphdb.database.nebula;

import com.alibaba.fastjson.util.AntiCollisionHashMap;
import com.neueda.jetbrains.plugin.graphdb.database.api.GraphDatabaseApi;
import com.neueda.jetbrains.plugin.graphdb.database.api.data.GraphMetadata;
import com.neueda.jetbrains.plugin.graphdb.database.api.query.GraphQueryResult;
import com.neueda.jetbrains.plugin.graphdb.database.nebula.data.NebulaEdge;
import com.neueda.jetbrains.plugin.graphdb.database.nebula.data.NebulaGraphMetadata;
import com.neueda.jetbrains.plugin.graphdb.database.nebula.data.NebulaSpace;
import com.neueda.jetbrains.plugin.graphdb.database.nebula.data.NebulaTag;
import com.neueda.jetbrains.plugin.graphdb.database.nebula.query.NebulaGraphQueryResult;
import com.vesoft.nebula.client.graph.SessionPool;
import com.vesoft.nebula.client.graph.SessionPoolConfig;
import com.vesoft.nebula.client.graph.data.HostAddress;
import com.vesoft.nebula.client.graph.data.ResultSet;
import com.vesoft.nebula.client.graph.exception.AuthFailedException;
import com.vesoft.nebula.client.graph.exception.BindSpaceFailedException;
import com.vesoft.nebula.client.graph.exception.ClientServerIncompatibleException;
import com.vesoft.nebula.client.graph.exception.IOErrorException;

import java.net.ConnectException;
import java.util.*;
import java.util.function.Function;

/**
 * 业务说明：
 *
 * @Author jiangyiwang-jk
 * @Date 2023/12/29 11:34
 */
public class NebulaDatabase implements GraphDatabaseApi {

    private NebulaConfiguration configuration;

    public NebulaDatabase(Map<String, String> config) {
        this.configuration = new NebulaConfiguration(config);
    }

    @Override
    public GraphQueryResult execute(String query) {
        return execute(query, null);
    }

    @Override
    public GraphQueryResult execute(String query, Map<String, Object> statementParameters) {
        return executeInSession(sessionPool -> {
            ResultSet resultSet;
            long startTime = System.currentTimeMillis();
            try {
                if (statementParameters != null && !statementParameters.isEmpty()) {
                    resultSet = sessionPool.execute(query, statementParameters);
                } else {
                    resultSet = sessionPool.execute(query);
                }
                return new NebulaGraphQueryResult(startTime, resultSet, null);
            } catch (Exception e) {
                return new NebulaGraphQueryResult(startTime, null, e);
            }
        });
    }

    private <T> T executeInSession(Function<SessionPool, T> executor) {
        List<HostAddress> addresses = Arrays.asList(new HostAddress(configuration.getHost(), configuration.getPort()));
        String spaceName = configuration.getDefaultSpace();
        String user = configuration.getUser();
        String password = configuration.getPassword();
        SessionPoolConfig sessionPoolConfig = new SessionPoolConfig(addresses, spaceName, user, password);
        sessionPoolConfig.setRetryTimes(3);
        sessionPoolConfig.setIntervalTime(1000);
        SessionPool sessionPool = new SessionPool(sessionPoolConfig);
        if (!sessionPool.init()) {
            throw new RuntimeException("Nebula session init fail!!");
        }
        try {
            return executor.apply(sessionPool);
        } finally {
            sessionPool.close();
        }
    }

    @Override
    public NebulaGraphMetadata metadata() {
        return executeInSession(sessionPool -> {
            try {
                ResultSet resultSet = sessionPool.execute(Consts.Stetments.SHOW_SPACE);
                if (resultSet.rowsSize() == 0) {
                    return new NebulaGraphMetadata(Collections.emptyList());
                }
                List<NebulaSpace> spaces = querySpaceList(sessionPool, resultSet);
                return new NebulaGraphMetadata(spaces);
            } catch (Exception e) {
                throw new RuntimeException("Execute nebula error", e);
            }
        });
    }

    private List<NebulaSpace> querySpaceList(SessionPool sessionPool, ResultSet resultSet) throws Exception {
        List<NebulaSpace> spaces = new ArrayList<>();
        for (int i = 0; i < resultSet.rowsSize(); i++) {
            ResultSet.Record valueWrappers = resultSet.rowValues(i);
            String spaceName = valueWrappers.get(0).asString();
            String useSpace = String.format(Consts.Stetments.USE_SPACE, spaceName);
            sessionPool.execute(useSpace);

            List<NebulaEdge> edgeList = querySpaceEdgeList(sessionPool);
            List<NebulaTag> tagList = querySpaceTagList(sessionPool);

            spaces.add(new NebulaSpace(spaceName, edgeList, tagList));

        }
        return spaces;
    }

    private List<NebulaEdge> querySpaceEdgeList(SessionPool sessionPool) throws Exception {
        String useSpace = String.format(Consts.Stetments.SHOW_EDGES);
        ResultSet resultSet = sessionPool.execute(useSpace);
        List<NebulaEdge> edgeList = new ArrayList<>();
        for (int i = 0; i < resultSet.rowsSize(); i++) {
            ResultSet.Record valueWrappers = resultSet.rowValues(i);
            String edgeName = valueWrappers.get(0).asString();
            Map<String, String> prop = getProp(sessionPool, String.format(Consts.Stetments.DESC_EDGE, edgeName));
            edgeList.add(new NebulaEdge(edgeName, prop));
        }
        return edgeList;
    }

    private List<NebulaTag> querySpaceTagList(SessionPool sessionPool) throws Exception {
        String useSpace = String.format(Consts.Stetments.SHOW_TAGS);
        ResultSet resultSet = sessionPool.execute(useSpace);
        List<NebulaTag> tagList = new ArrayList<>();
        for (int i = 0; i < resultSet.rowsSize(); i++) {
            ResultSet.Record valueWrappers = resultSet.rowValues(i);
            String edgeName = valueWrappers.get(0).asString();
            Map<String, String> prop = getProp(sessionPool, String.format(Consts.Stetments.DESC_TAG, edgeName));
            tagList.add(new NebulaTag(edgeName, prop));
        }
        return tagList;
    }

    private Map<String, String> getProp(SessionPool sessionPool, String sql) throws Exception {
        ResultSet resultSet = sessionPool.execute(sql);
        Map<String, String> prop = new HashMap<>();
        for (int i = 0; i < resultSet.rowsSize(); i++) {
            ResultSet.Record valueWrappers = resultSet.rowValues(i);
            String fieldName = valueWrappers.get(0).asString();
            String type = valueWrappers.get(1).asString();
            prop.put(fieldName, type);
        }
        return prop;
    }

}
