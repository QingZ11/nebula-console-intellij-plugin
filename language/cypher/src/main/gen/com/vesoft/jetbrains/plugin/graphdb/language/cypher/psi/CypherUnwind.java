// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CypherUnwind extends PsiElement {

  @NotNull
  CypherExpression getExpression();

  @NotNull
  CypherVariable getVariable();

  @NotNull
  PsiElement getKAs();

  @NotNull
  PsiElement getKUnwind();

}