package com.vesoft.jetbrains.plugin.graphdb.jetbrains.ui.datasource.tree;

import com.vesoft.jetbrains.plugin.graphdb.jetbrains.component.datasource.state.DataSourceApi;

import java.util.Optional;

public class RelationshipTypeTreeNodeModel extends MetadataTreeNodeModel {

    private static final String NAME_WITH_COUNT = "%s (%d)";
    private Long count;

    public RelationshipTypeTreeNodeModel(Neo4jTreeNodeType type, DataSourceApi dataSourceApi, String value, Long count) {
        super(type, dataSourceApi, value);
        this.count = count;
    }

    @Override
    public Optional<String> getText() {
        return super.getText()
                .map(text -> String.format(NAME_WITH_COUNT, text, count));
    }
}
