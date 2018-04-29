package com.fooock.solidity.lang.psi;

import com.fooock.solidity.lang.SolidityLang;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Solidity element type
 */
public class SolidityElementType extends IElementType {

    public SolidityElementType(@NotNull String debugName) {
        super(debugName, SolidityLang.INSTANCE);
    }
}
