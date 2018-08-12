package com.fooock.solidity.lang.support;

import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler;

/**
 *
 */
public class SolidityQuoteHandler extends SimpleTokenSetQuoteHandler {

    public SolidityQuoteHandler() {
        super(SolidityTypes.STRING_LITERAL);
    }
}
