// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface CypherInQueryCall extends PsiElement {

  @NotNull
  CypherCall getCall();

  @Nullable
  CypherWhere getWhere();

}