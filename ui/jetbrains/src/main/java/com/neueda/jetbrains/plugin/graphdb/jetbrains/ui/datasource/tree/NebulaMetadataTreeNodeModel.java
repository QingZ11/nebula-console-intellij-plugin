package com.neueda.jetbrains.plugin.graphdb.jetbrains.ui.datasource.tree;

import com.neueda.jetbrains.plugin.graphdb.jetbrains.component.datasource.state.DataSourceApi;
import com.neueda.jetbrains.plugin.graphdb.jetbrains.ui.datasource.metadata.dto.ContextMenu;
import com.neueda.jetbrains.plugin.graphdb.jetbrains.ui.datasource.metadata.dto.MetadataContextMenu;

import javax.swing.*;
import java.util.Optional;

public class NebulaMetadataTreeNodeModel implements TreeNodeModelApi {

    private MetadataContextMenu metadataContextMenu;
    private NodeType type;
    private Icon icon;
    private String value;
    private DataSourceApi dataSourceApi;

    public NebulaMetadataTreeNodeModel(NebulaTreeNodeType type, DataSourceApi dataSourceApi, String value) {
        this(type, dataSourceApi, value, null);
    }

    public NebulaMetadataTreeNodeModel(NebulaTreeNodeType type, DataSourceApi dataSourceApi, String value, Icon icon) {
        this.type = type;
        this.value = value;
        this.dataSourceApi = dataSourceApi;
        this.icon = icon;
        prepareContextMenu();
    }

    private void prepareContextMenu() {
        if (type == NebulaTreeNodeType.SPACE
                || type == NebulaTreeNodeType.EDGE
                || type == NebulaTreeNodeType.TAG) {
            metadataContextMenu = new MetadataContextMenu(type, getDataSourceApi(), value);
        }
    }

    public Optional<ContextMenu> getContextMenu() {
        return Optional.ofNullable(metadataContextMenu);
    }

    @Override
    public NodeType getType() {
        return type;
    }

    public void setType(Neo4jTreeNodeType type) {
        this.type = type;
    }

    @Override
    public Optional<Icon> getIcon() {
        return Optional.ofNullable(icon);
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    @Override
    public Optional<String> getText() {
        return Optional.ofNullable(value);
    }

    @Override
    public Optional<Object> getValue() {
        return Optional.ofNullable(value);
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public DataSourceApi getDataSourceApi() {
        return dataSourceApi;
    }
}
