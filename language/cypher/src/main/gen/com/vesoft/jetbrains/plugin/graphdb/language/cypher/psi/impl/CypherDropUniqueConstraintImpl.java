// This is a generated file. Not intended for manual editing.
package com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.impl;

import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherDropUniqueConstraint;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherUniqueConstraintSyntax;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherVisitor;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;

import static com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.CypherTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.vesoft.jetbrains.plugin.graphdb.language.cypher.psi.*;

public class CypherDropUniqueConstraintImpl extends ASTWrapperPsiElement implements CypherDropUniqueConstraint {

  public CypherDropUniqueConstraintImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull CypherVisitor visitor) {
    visitor.visitDropUniqueConstraint(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof CypherVisitor) accept((CypherVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public CypherUniqueConstraintSyntax getUniqueConstraintSyntax() {
    return findNotNullChildByClass(CypherUniqueConstraintSyntax.class);
  }

  @Override
  @NotNull
  public PsiElement getKDrop() {
    return findNotNullChildByType(K_DROP);
  }

}
