package com.fooock.solidity.lang.highlighter;

import com.fooock.solidity.lang.lexer.SolidityLexerAdapter;
import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

import static com.fooock.solidity.lang.highlighter.Attributes.*;

/**
 *
 */
public class SolidityHighlighter extends SyntaxHighlighterBase {

    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] OPERATORS = new TextAttributesKey[]{OPERATOR_SIGN};
    private static final TextAttributesKey[] NUMBERS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] STRINGS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private final Map<IElementType, TextAttributesKey[]> attributesKeyMap;

    SolidityHighlighter() {
        attributesKeyMap = new HashMap<>();
        // Comments
        attributesKeyMap.put(SolidityTypes.COMMENT, COMMENT_KEYS);

        // Types
        attributesKeyMap.put(SolidityTypes.DECIMAL_NUMBER, NUMBERS);
        attributesKeyMap.put(SolidityTypes.HEX_NUMBER, NUMBERS);
        attributesKeyMap.put(SolidityTypes.PRAGMA_VERSION, NUMBERS);
        attributesKeyMap.put(SolidityTypes.STRING_LITERAL, STRINGS);

        // Operators
        attributesKeyMap.put(SolidityTypes.PLUS, OPERATORS);
        attributesKeyMap.put(SolidityTypes.PLUS_PLUS, OPERATORS);
        attributesKeyMap.put(SolidityTypes.PLUS_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.NOT_EQ, OPERATORS);
        attributesKeyMap.put(SolidityTypes.NOT, OPERATORS);
        attributesKeyMap.put(SolidityTypes.MINUS_MINUS, OPERATORS);
        attributesKeyMap.put(SolidityTypes.MINUS_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.MINUS, OPERATORS);
        attributesKeyMap.put(SolidityTypes.COND_OR, OPERATORS);
        attributesKeyMap.put(SolidityTypes.BIT_OR_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.COND_AND, OPERATORS);
        attributesKeyMap.put(SolidityTypes.BIT_AND_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.BIT_AND, OPERATORS);
        attributesKeyMap.put(SolidityTypes.BIT_OR, OPERATORS);
        attributesKeyMap.put(SolidityTypes.SHIFT_LEFT_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.SHIFT_LEFT, OPERATORS);
        attributesKeyMap.put(SolidityTypes.LESS_OR_EQUAL, OPERATORS);
        attributesKeyMap.put(SolidityTypes.LESS, OPERATORS);
        attributesKeyMap.put(SolidityTypes.BIT_XOR_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.BIT_XOR, OPERATORS);
        attributesKeyMap.put(SolidityTypes.MUL_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.MUL, OPERATORS);
        attributesKeyMap.put(SolidityTypes.QUOTIENT_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.QUOTIENT, OPERATORS);
        attributesKeyMap.put(SolidityTypes.REMAINDER_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.REMAINDER, OPERATORS);
        attributesKeyMap.put(SolidityTypes.SHIFT_RIGHT_ASSIGN, OPERATORS);
        attributesKeyMap.put(SolidityTypes.SHIFT_RIGHT, OPERATORS);
        attributesKeyMap.put(SolidityTypes.GREATER_OR_EQUAL, OPERATORS);
        attributesKeyMap.put(SolidityTypes.GREATER, OPERATORS);
        attributesKeyMap.put(SolidityTypes.TILDE, OPERATORS);
        attributesKeyMap.put(SolidityTypes.EXPONENT, OPERATORS);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SolidityLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        if (attributesKeyMap.containsKey(tokenType))
            return attributesKeyMap.get(tokenType);
        // if not found, return empty
        return EMPTY_KEYS;
    }
}
