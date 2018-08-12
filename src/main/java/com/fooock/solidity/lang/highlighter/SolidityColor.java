package com.fooock.solidity.lang.highlighter;

import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

/**
 *
 */
final class SolidityColor {

    static final TextAttributesKey COMMENT = createTextAttributesKey("SOLIDITY_COMMENT",
            DefaultLanguageHighlighterColors.LINE_COMMENT);

    static final TextAttributesKey OPERATOR_SIGN = createTextAttributesKey("SOLIDITY_OPERATOR",
            DefaultLanguageHighlighterColors.OPERATION_SIGN);

    static final TextAttributesKey NUMBER = createTextAttributesKey("SOLIDITY_NUMBER",
            DefaultLanguageHighlighterColors.NUMBER);

    static final TextAttributesKey STRING = createTextAttributesKey("SOLIDITY_STRING",
            DefaultLanguageHighlighterColors.STRING);

    static final TextAttributesKey KEYWORD = createTextAttributesKey("SOLIDITY_KEYWORD",
            DefaultLanguageHighlighterColors.KEYWORD);

    static final TextAttributesKey SEMI_COLON = createTextAttributesKey("SOLIDITY_SEMICOLON",
            DefaultLanguageHighlighterColors.SEMICOLON);

    static final TextAttributesKey BRACE = createTextAttributesKey("SOLIDITY_BRACE",
            DefaultLanguageHighlighterColors.BRACES);

    static final TextAttributesKey BRACKET = createTextAttributesKey("SOLIDITY_BRACKET",
            DefaultLanguageHighlighterColors.BRACKETS);

    static final TextAttributesKey PAREN = createTextAttributesKey("SOLIDITY_PAREN",
            DefaultLanguageHighlighterColors.PARENTHESES);

    static final TextAttributesKey FUNCTION_DEC = createTextAttributesKey("SOLIDITY_FUNCTION_DEC",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

    static final TextAttributesKey MODIFIER_DEC = createTextAttributesKey("SOLIDITY_MODIFIER_DEC",
            DefaultLanguageHighlighterColors.FUNCTION_DECLARATION);

    static final TextAttributesKey MODIFIER_INVOCATION = createTextAttributesKey("SOLIDITY_MODIFIER_INVOCATION",
            DefaultLanguageHighlighterColors.METADATA);
}
