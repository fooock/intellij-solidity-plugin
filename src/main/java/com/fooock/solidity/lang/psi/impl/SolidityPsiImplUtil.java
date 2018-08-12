package com.fooock.solidity.lang.psi.impl;

import com.fooock.solidity.lang.psi.SolidityImportAlias;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class SolidityPsiImplUtil {

    @NotNull
    public static String getName(@NotNull SolidityImportAlias importAlias) {
        PsiElement identifier = importAlias.getIdentifier();
        return identifier.getText();
    }
}
