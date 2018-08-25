package com.fooock.solidity.lang.reference;

import com.fooock.solidity.lang.psi.SolidityVariableLiteral;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;

/**
 *
 */
public class SolidityVariableReference extends SolidityReference<SolidityVariableLiteral> {

    public SolidityVariableReference(SolidityVariableLiteral element) {
        super(element, element.getTextRange());
    }

    @NotNull
    @Override
    protected List<PsiElement> resolveForElement() {
        // TODO: get resolved references for this element
        return Collections.emptyList();
    }
}
