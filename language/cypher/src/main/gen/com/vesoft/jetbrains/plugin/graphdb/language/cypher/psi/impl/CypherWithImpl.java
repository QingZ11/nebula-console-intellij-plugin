// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.impl;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherReturnBody;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherVisitor;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherWhere;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherWith;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.*;

public class CypherWithImpl extends ASTWrapperPsiElement implements CypherWith {

  public CypherWithImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitWith(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CypherReturnBody getReturnBody() {
    return findNotNullChildByClass(CypherReturnBody.class);
  }

  @Override
  @Nullable
  public CypherWhere getWhere() {
    return findChildByClass(CypherWhere.class);
  }

  @Override
  @Nullable
  public PsiElement getKDistinct() {
    return findChildByType(K_DISTINCT);
  }

  @Override
  @NotNull
  public PsiElement getKWith() {
    return findNotNullChildByType(K_WITH);
  }

}