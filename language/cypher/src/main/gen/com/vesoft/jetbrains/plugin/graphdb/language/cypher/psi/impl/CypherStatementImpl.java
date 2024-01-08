// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.impl;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.*;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.*;

public class CypherStatementImpl extends ASTWrapperPsiElement implements CypherStatement {

  public CypherStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public CypherCommand getCommand() {
    return findChildByClass(CypherCommand.class);
  }

  @Override
  @Nullable
  public CypherQuery getQuery() {
    return findChildByClass(CypherQuery.class);
  }

  @Override
  @Nullable
  public CypherQueryOptions getQueryOptions() {
    return findChildByClass(CypherQueryOptions.class);
  }

  @Override
  @Nullable
  public PsiElement getKBegin() {
    return findChildByType(K_BEGIN);
  }

  @Override
  @Nullable
  public PsiElement getKCommit() {
    return findChildByType(K_COMMIT);
  }

}
