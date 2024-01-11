// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.impl;

import java.util.List;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherRegularQuery;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherSingleQuery;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherUnion;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.*;

public class CypherRegularQueryImpl extends ASTWrapperPsiElement implements CypherRegularQuery {

  public CypherRegularQueryImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitRegularQuery(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CypherSingleQuery getSingleQuery() {
    return findNotNullChildByClass(CypherSingleQuery.class);
  }

  @Override
  @NotNull
  public List<CypherUnion> getUnionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CypherUnion.class);
  }

}