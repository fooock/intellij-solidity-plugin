package com.fooock.solidity.lang.support;

import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public class SolidityBraceMatcher implements PairedBraceMatcher {

    @NotNull
    @Override
    public BracePair[] getPairs() {
        return new BracePair[]{
                new BracePair(SolidityTypes.LBRACE, SolidityTypes.RBRACE, false),
                new BracePair(SolidityTypes.LPAREN, SolidityTypes.RPAREN, false),
                new BracePair(SolidityTypes.LBRACK, SolidityTypes.RBRACK, false)
        };
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
