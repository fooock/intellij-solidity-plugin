package com.fooock.solidity.lang.lexer;

import com.intellij.lexer.FlexAdapter;

/**
 * Solidity Flex adapter
 */
public class SolidityLexerAdapter extends FlexAdapter {

    public SolidityLexerAdapter() {
        super(new _SolidityLexer(null));
    }
}
