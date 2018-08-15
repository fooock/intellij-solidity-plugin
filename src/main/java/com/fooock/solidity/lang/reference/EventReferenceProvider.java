package com.fooock.solidity.lang.reference;

import com.fooock.solidity.lang.psi.SolidityEventDefinition;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;
import com.intellij.psi.PsiReferenceProvider;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class EventReferenceProvider extends PsiReferenceProvider {
    private static final PsiReference[] EMPTY_REFERENCE = new PsiReference[0];

    @NotNull
    @Override
    public PsiReference[] getReferencesByElement(@NotNull PsiElement element, @NotNull ProcessingContext context) {
        SolidityEventDefinition definition = (SolidityEventDefinition) element;
        PsiElement identifier = definition.getIdentifier();
        if (identifier == null) return EMPTY_REFERENCE;

        return new PsiReference[]{new SolidityReference(element, identifier.getTextRange())};
    }
}
