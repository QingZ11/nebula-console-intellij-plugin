// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CypherCommand extends PsiElement {

  @Nullable
  CypherCreateIndex getCreateIndex();

  @Nullable
  CypherCreateNodePropertyExistenceConstraint getCreateNodePropertyExistenceConstraint();

  @Nullable
  CypherCreateRelationshipPropertyExistenceConstraint getCreateRelationshipPropertyExistenceConstraint();

  @Nullable
  CypherCreateUniqueConstraint getCreateUniqueConstraint();

  @Nullable
  CypherDropIndex getDropIndex();

  @Nullable
  CypherDropNodePropertyExistenceConstraint getDropNodePropertyExistenceConstraint();

  @Nullable
  CypherDropRelationshipPropertyExistenceConstraint getDropRelationshipPropertyExistenceConstraint();

  @Nullable
  CypherDropUniqueConstraint getDropUniqueConstraint();

}
