package com.fooock.solidity.lang.psi.impl;

import com.fooock.solidity.lang.psi.SolidityNamedElement;
import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public abstract class SolidityNamedElementImpl extends ASTWrapperPsiElement implements SolidityNamedElement {

    SolidityNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public String getName() {
        if (getNameIdentifier() == null) return null;
        return getNameIdentifier().getText();
    }

    @Nullable
    @Override
    public PsiElement getNameIdentifier() {
        return findChildByType(SolidityTypes.IDENTIFIER);
    }

    @Override
    public int getTextOffset() {
        // we need to override this method because we override getNameIdentifier()
        if (getNameIdentifier() == null) return super.getTextOffset();
        return getNameIdentifier().getTextOffset();
    }

    @Override
    public PsiElement setName(@NotNull String name) throws IncorrectOperationException {
        return this;
    }
}
