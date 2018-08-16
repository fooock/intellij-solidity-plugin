package com.fooock.solidity.lang.reference;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

/**
 *
 */
public class SolidityReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {
    private static final ResolveResult[] EMPTY_RESOLVE_RESULTS = new ResolveResult[0];
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    SolidityReference(PsiElement element, TextRange rangeInElement) {
        super(element, rangeInElement);
    }

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        return EMPTY_RESOLVE_RESULTS;
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] results = multiResolve(false);
        return results.length == 0 ? null : results[0].getElement();
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return EMPTY_OBJECT_ARRAY;
    }

    private static <T extends PsiElement> ResolveResult[] transform(List<T> list) {
        ResolveResult[] results = new ResolveResult[list.size()];
        for (int i = 0; i < list.size(); i++) {
            results[i] = new PsiElementResolveResult(list.get(i));
        }
        return results;
    }
}
