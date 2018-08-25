package com.fooock.solidity.lang.psi.mixin;

import com.fooock.solidity.lang.psi.SolidityVariableLiteral;
import com.fooock.solidity.lang.psi.impl.SolidityNamedElementImpl;
import com.fooock.solidity.lang.reference.SolidityReference;
import com.fooock.solidity.lang.reference.SolidityVariableReference;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public abstract class SolidityVariableMixin extends SolidityNamedElementImpl implements SolidityVariableLiteral {

    public SolidityVariableMixin(@NotNull ASTNode node) {
        super(node);
    }

    @Override
    public SolidityReference getReference() {
        return new SolidityVariableReference(this);
    }
}
