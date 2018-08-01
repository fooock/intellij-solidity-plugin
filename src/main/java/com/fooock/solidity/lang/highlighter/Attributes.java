package com.fooock.solidity.lang.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 *
 */
final class Attributes {

    static final TextAttributesKey COMMENT = createTextAttributesKey("SOLIDITY_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);

    static final TextAttributesKey OPERATOR_SIGN = createTextAttributesKey("SOLIDITY_OPERATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN);

    static final TextAttributesKey NUMBER = createTextAttributesKey("SOLIDITY_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER);

    static final TextAttributesKey STRING = createTextAttributesKey("SOLIDITY_STRING",
            DefaultLanguageHighlighterColors.STRING);

}
