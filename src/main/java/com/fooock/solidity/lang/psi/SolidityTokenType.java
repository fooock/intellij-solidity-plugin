package com.fooock.solidity.lang.psi;

import com.fooock.solidity.lang.SolidityLang;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

/**
 * Solidity token type
 */
public class SolidityTokenType extends IElementType {

    public SolidityTokenType(@NotNull String debugName) {
        super(debugName, SolidityLang.INSTANCE);
    }
}
