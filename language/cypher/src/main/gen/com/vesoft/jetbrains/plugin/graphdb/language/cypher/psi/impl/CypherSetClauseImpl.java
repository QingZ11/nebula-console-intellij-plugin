// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.impl;

import java.util.List;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherSetClause;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherSetItem;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.*;

public class CypherSetClauseImpl extends ASTWrapperPsiElement implements CypherSetClause {

  public CypherSetClauseImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitSetClause(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<CypherSetItem> getSetItemList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, CypherSetItem.class);
  }

  @Override
  @NotNull
  public PsiElement getKSet() {
    return findNotNullChildByType(K_SET);
  }

}
