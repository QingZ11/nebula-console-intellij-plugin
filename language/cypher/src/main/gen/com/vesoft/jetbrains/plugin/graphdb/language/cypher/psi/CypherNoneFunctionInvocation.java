// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.references.CypherInvocation;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CypherNoneFunctionInvocation extends CypherInvocation {

  @NotNull
  CypherFilterExpression getFilterExpression();

  @NotNull
  PsiElement getKNone();

  String getFullName();

}