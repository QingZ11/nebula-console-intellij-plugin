package com.vesoft.jetbrains.plugin.graphdb.language.cypher.references.types;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.completion.metadata.atoms.CypherType;

import static com.vesoft.jetbrains.plugin.graphdb.language.cypher.completion.metadata.atoms.CypherSimpleType.INTEGER;

public interface CypherIntegerYielding extends CypherTyped {

    @Override
    default CypherType getType() {
        return INTEGER;
    }

}