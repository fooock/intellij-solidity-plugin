package com.fooock.solidity.lang.usage;

import com.fooock.solidity.lang.lexer.SolidityLexerAdapter;
import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.lang.cacheBuilder.DefaultWordsScanner;
import com.intellij.psi.tree.TokenSet;

/**
 *
 */
final class SolidityWordScanner extends DefaultWordsScanner {

    SolidityWordScanner() {
        super(new SolidityLexerAdapter(), TokenSet.create(SolidityTypes.IDENTIFIER),
                TokenSet.create(SolidityTypes.COMMENT), TokenSet.create(SolidityTypes.STRING_LITERAL));
    }
}
