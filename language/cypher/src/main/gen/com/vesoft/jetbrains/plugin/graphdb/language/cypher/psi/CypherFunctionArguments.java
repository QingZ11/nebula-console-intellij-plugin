// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi;

import java.util.List;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.references.CypherArgumentList;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CypherFunctionArguments extends CypherArgumentList {

  @NotNull
  List<CypherExpression> getExpressionList();

  @Nullable
  PsiElement getKDistinct();

}