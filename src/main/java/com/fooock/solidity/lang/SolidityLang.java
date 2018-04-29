package com.fooock.solidity.lang;

import com.intellij.lang.Language;

/**
 * Solidity language
 */
public class SolidityLang extends Language {
    static final SolidityLang INSTANCE = new SolidityLang();

    private SolidityLang() {
        super("Solidity");
    }

    @Override
    public boolean isCaseSensitive() {
        return true;
    }
}
