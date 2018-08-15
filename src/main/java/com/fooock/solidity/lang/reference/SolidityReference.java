package com.fooock.solidity.lang.reference;

import com.fooock.solidity.lang.psi.SolidityEventDefinition;
import com.fooock.solidity.lang.util.SolidityUtils;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
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
        if (myElement instanceof SolidityEventDefinition) {
            SolidityEventDefinition eventDefinition = (SolidityEventDefinition) myElement;
            PsiElement identifier = eventDefinition.getIdentifier();

            if (identifier == null) return EMPTY_RESOLVE_RESULTS;

            List<SolidityEventDefinition> eventDefinitions = SolidityUtils.findEventDefinitions(
                    myElement.getProject(), identifier.getText());
            return transform(eventDefinitions);
        }
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
        if (myElement instanceof SolidityEventDefinition) {
            SolidityEventDefinition eventDefinition = (SolidityEventDefinition) myElement;
            PsiElement identifier = eventDefinition.getIdentifier();

            if (identifier == null) return EMPTY_RESOLVE_RESULTS;

            List<SolidityEventDefinition> eventDefinitions = SolidityUtils.findEventDefinitions(
                    myElement.getProject(), identifier.getText());

            List<LookupElement> variants = new ArrayList<>(eventDefinitions.size());
            for (SolidityEventDefinition event : eventDefinitions) {
                if (event.getIdentifier() == null) continue;
                variants.add(LookupElementBuilder.create(event).withTypeText(event.getContainingFile().getName()));
            }
            return variants.toArray();
        }
        return EMPTY_OBJECT_ARRAY;
    }

    private <T extends PsiElement> ResolveResult[] transform(List<T> list) {
        ResolveResult[] results = new ResolveResult[list.size()];
        for (int i = 0; i < list.size(); i++) {
            results[i] = new PsiElementResolveResult(list.get(i));
        }
        return results;
    }
}
