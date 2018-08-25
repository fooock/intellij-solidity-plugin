package com.fooock.solidity.lang.reference;

import com.fooock.solidity.lang.psi.SolidityNamedElement;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.impl.source.resolve.ResolveCache;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * Base class for all references
 */
public abstract class SolidityReference<T extends SolidityReferenceElement> extends PsiPolyVariantReferenceBase<T> implements PsiPolyVariantReference {
    private static final ResolveResult[] RESOLVE_RESULT_TYPE = new ResolveResult[0];
    private static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    SolidityReference(T element, TextRange range) {
        super(element, range);
    }

    @NotNull
    protected abstract List<PsiElement> resolveForElement();

    @NotNull
    @Override
    public ResolveResult[] multiResolve(boolean incompleteCode) {
        return ResolveCache.getInstance(myElement.getProject())
                .resolveWithCaching(this, (solidityReference, code) -> getResolveResults(solidityReference), true, incompleteCode);
    }

    @NotNull
    private ResolveResult[] getResolveResults(SolidityReference<T> solidityReference) {
        List<PsiElement> elements = solidityReference.resolveForElement();
        if (elements.isEmpty()) return RESOLVE_RESULT_TYPE;

        List<PsiElementResolveResult> results = new ArrayList<>(elements.size());
        for (PsiElement element : elements) {
            results.add(new PsiElementResolveResult(element));
        }
        return results.toArray(RESOLVE_RESULT_TYPE);
    }

    @NotNull
    @Override
    public Object[] getVariants() {
        return EMPTY_OBJECT_ARRAY;
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        PsiElement element = super.resolve();
        return element != null ? ((SolidityNamedElement) element) : null;
    }
}
