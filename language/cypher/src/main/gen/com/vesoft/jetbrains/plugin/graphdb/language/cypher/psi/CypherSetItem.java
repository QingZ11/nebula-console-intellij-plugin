// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CypherSetItem extends PsiElement {

  @Nullable
  CypherExpression getExpression();

  @Nullable
  CypherNodeLabels getNodeLabels();

  @Nullable
  CypherPropertyExpression getPropertyExpression();

  @Nullable
  CypherVariable getVariable();

}
