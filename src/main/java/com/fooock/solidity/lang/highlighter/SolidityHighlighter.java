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
    private static final TextAttributesKey[] KEYWORDS = new TextAttributesKey[]{KEYWORD};
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

        attributesKeyMap.put(SolidityTypes.INT, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT8, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT16, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT24, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT32, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT40, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT48, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT56, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT64, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT72, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT80, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT88, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT96, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT104, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT112, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT120, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT128, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT136, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT144, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT152, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT160, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT168, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT176, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT184, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT192, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT200, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT208, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT216, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT224, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT232, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT240, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT248, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.INT256, KEYWORDS);

        attributesKeyMap.put(SolidityTypes.UINT, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT8, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT16, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT24, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT32, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT40, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT48, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT56, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT64, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT72, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT80, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT88, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT96, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT104, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT112, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT120, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT128, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT136, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT144, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT152, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT160, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT168, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT176, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT184, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT192, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT200, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT208, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT216, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT224, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT232, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT240, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT248, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.UINT256, KEYWORDS);

        attributesKeyMap.put(SolidityTypes.BYTE, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES1, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES2, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES3, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES4, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES5, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES6, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES7, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES8, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES9, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES10, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES11, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES12, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES13, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES14, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES15, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES16, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES17, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES18, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES19, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES20, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES21, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES22, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES23, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES24, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES25, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES26, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES27, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES28, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES29, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES30, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES31, KEYWORDS);
        attributesKeyMap.put(SolidityTypes.BYTES32, KEYWORDS);
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
