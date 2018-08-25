package com.fooock.solidity.lang.reference;

import com.fooock.solidity.lang.psi.SolidityNamedElement;
import com.intellij.psi.PsiReference;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public interface SolidityReferenceElement extends SolidityNamedElement {

    @Nullable
    @Override
    PsiReference getReference();
}
