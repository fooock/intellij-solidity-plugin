package com.fooock.solidity.lang.reference;

import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiReferenceContributor;
import com.intellij.psi.PsiReferenceRegistrar;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class SolidityReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(SolidityTypes.EVENT_DEFINITION), new EventReferenceProvider());
    }
}
