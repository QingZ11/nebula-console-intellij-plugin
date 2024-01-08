// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.impl;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.*;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.*;

public class CypherReturnBodyImpl extends ASTWrapperPsiElement implements CypherReturnBody {

  public CypherReturnBodyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitReturnBody(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CypherLimit getLimit() {
    return findChildByClass(CypherLimit.class);
  }

  @Override
  @Nullable
  public CypherOrder getOrder() {
    return findChildByClass(CypherOrder.class);
  }

  @Override
  @NotNull
  public CypherReturnItems getReturnItems() {
    return findNotNullChildByClass(CypherReturnItems.class);
  }

  @Override
  @Nullable
  public CypherSkip getSkip() {
    return findChildByClass(CypherSkip.class);
  }

}
