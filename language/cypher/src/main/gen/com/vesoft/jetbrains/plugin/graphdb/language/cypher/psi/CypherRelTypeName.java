// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.references.CypherNamedElement;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

public interface CypherRelTypeName extends CypherNamedElement {

  @NotNull
  CypherSymbolicNameString getSymbolicNameString();

  String getName();

  CypherRelTypeName setName(String newName);

  PsiElement getNameIdentifier();

  @NotNull
  PsiReference[] getReferences();

}