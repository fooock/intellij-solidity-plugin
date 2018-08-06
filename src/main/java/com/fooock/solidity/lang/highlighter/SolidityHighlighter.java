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
    private static final TextAttributesKey[] KEYWORDS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    private final Map<IElementType, TextAttributesKey[]> attributesKeyMap;

    SolidityHighlighter() {
        attributesKeyMap = new HashMap<>();
        // Comments
        attributesKeyMap.put(SolidityTypes.COMMENT, COMMENT_KEYS);

        // Types content
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

        // Contract definition keywords
        attributesKeyMap.put(SolidityTypes.CONTRACT, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.IS, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.FUNCTION, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INTERFACE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.LIBRARY, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.CONSTRUCTOR, KEYWORDS);

        // Contract state visibility keywords
        attributesKeyMap.put(SolidityTypes.PUBLIC, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.PRIVATE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INTERNAL, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.EXTERNAL, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.PURE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.CONSTANT, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.PAYABLE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.VIEW, KEYWORDS);

        // Variable state keywords
        attributesKeyMap.put(SolidityTypes.MEMORY, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.STORAGE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.DELETE_OPERATOR, KEYWORDS);

        // Number unit keywords
        attributesKeyMap.put(SolidityTypes.WEI, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.FINNEY, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.SZABO, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.ETHER, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.SECONDS, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.MINUTES, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.HOURS, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.DAYS, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.WEEKS, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.YEARS, KEYWORDS);

        // Mixed keywords
        attributesKeyMap.put(SolidityTypes.MODIFIER, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.RETURN, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.RETURNS, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.EMIT, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INDEXED, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.NEW, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.PRAGMA, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.IMPORT, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.AS, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.FROM, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.USING, KEYWORDS);

        // Statements keywords
        attributesKeyMap.put(SolidityTypes.IF, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.ELSE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.FOR, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.WHILE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.ASSEMBLY, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.DO, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.CONTINUE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BREAK, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.THROW, KEYWORDS);

        // Variable types keywords
        attributesKeyMap.put(SolidityTypes.TRUE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.FALSE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.ADDRESS, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BOOL, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.STRING, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.VAR, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.MAPPING, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.STRUCT, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.ENUM, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.LET, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.EVENT, KEYWORDS);
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
