package com.vesoft.jetbrains.plugin.graphdb.database.nebula.data;

import com.vesoft.jetbrains.plugin.graphdb.database.api.data.GraphMetadata;

import java.util.List;
import java.util.Map;

/**
 * 业务说明：
 *
 * @Author jiangyiwang-jk
 * @Date 2023/12/29 16:44
 */
public class NebulaGraphMetadata implements GraphMetadata {

    private List<NebulaSpace> nebulaSpaceList;

    private String currentSpace;

    public NebulaGraphMetadata(String currentSpace,List<NebulaSpace> nebulaSpaceList) {
        this.currentSpace = currentSpace;
        this.nebulaSpaceList = nebulaSpaceList;
    }

    public List<NebulaSpace> getNebulaSpaceList() {
        return nebulaSpaceList;
    }

    @Override
    public Map<String, Number> labels() {
        return null;
    }

    @Override
    public Map<String, Number> relationships() {
        return null;
    }

    @Override
    public Iterable<String> vertexProperties() {
        return null;
    }

    @Override
    public Iterable<String> edgeProperties() {
        return null;
    }

    public String getCurrentSpace() {
        return currentSpace;
    }
}
