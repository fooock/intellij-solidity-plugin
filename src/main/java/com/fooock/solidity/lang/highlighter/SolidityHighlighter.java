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

import static com.fooock.solidity.lang.highlighter.SolidityColor.*;

/**
 *
 */
public class SolidityHighlighter extends SyntaxHighlighterBase {

    private final Map<IElementType, TextAttributesKey> attributesKeyMap;

    SolidityHighlighter() {
        attributesKeyMap = new HashMap<>();
        // Symbols
        attributesKeyMap.put(SolidityTypes.SEMICOLON, SEMI_COLON);
        attributesKeyMap.put(SolidityTypes.LBRACE, BRACE);
        attributesKeyMap.put(SolidityTypes.RBRACE, BRACE);
        attributesKeyMap.put(SolidityTypes.LBRACK, BRACKET);
        attributesKeyMap.put(SolidityTypes.RBRACK, BRACKET);
        attributesKeyMap.put(SolidityTypes.LPAREN, PAREN);
        attributesKeyMap.put(SolidityTypes.RPAREN, PAREN);

        // Comments
        attributesKeyMap.put(SolidityTypes.COMMENT, COMMENT);

        // Types content
        attributesKeyMap.put(SolidityTypes.DECIMAL_NUMBER, NUMBER);
        attributesKeyMap.put(SolidityTypes.HEX_NUMBER, NUMBER);
        attributesKeyMap.put(SolidityTypes.PRAGMA_VERSION, NUMBER);
        attributesKeyMap.put(SolidityTypes.STRING_LITERAL, STRING);

        // Operators
        attributesKeyMap.put(SolidityTypes.PLUS, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.PLUS_PLUS, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.PLUS_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.NOT_EQ, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.NOT, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.MINUS_MINUS, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.MINUS_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.MINUS, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.COND_OR, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.BIT_OR_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.COND_AND, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.BIT_AND_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.BIT_AND, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.BIT_OR, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.SHIFT_LEFT_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.SHIFT_LEFT, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.LESS_OR_EQUAL, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.LESS, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.BIT_XOR_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.BIT_XOR, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.MUL_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.MUL, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.QUOTIENT_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.QUOTIENT, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.REMAINDER_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.REMAINDER, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.SHIFT_RIGHT_ASSIGN, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.SHIFT_RIGHT, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.GREATER_OR_EQUAL, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.GREATER, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.TILDE, OPERATOR_SIGN);
        attributesKeyMap.put(SolidityTypes.EXPONENT, OPERATOR_SIGN);

        // Contract definition keywords
        attributesKeyMap.put(SolidityTypes.CONTRACT, KEYWORD);
        attributesKeyMap.put(SolidityTypes.IS, KEYWORD);
        attributesKeyMap.put(SolidityTypes.FUNCTION, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INTERFACE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.LIBRARY, KEYWORD);
        attributesKeyMap.put(SolidityTypes.CONSTRUCTOR, KEYWORD);
        attributesKeyMap.put(SolidityTypes.SUPER_OPERATOR, KEYWORD);

        // Contract state visibility keywords
        attributesKeyMap.put(SolidityTypes.PUBLIC, KEYWORD);
        attributesKeyMap.put(SolidityTypes.PRIVATE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INTERNAL, KEYWORD);
        attributesKeyMap.put(SolidityTypes.EXTERNAL, KEYWORD);
        attributesKeyMap.put(SolidityTypes.PURE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.CONSTANT, KEYWORD);
        attributesKeyMap.put(SolidityTypes.PAYABLE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.VIEW, KEYWORD);

        // Variable state keywords
        attributesKeyMap.put(SolidityTypes.MEMORY, KEYWORD);
        attributesKeyMap.put(SolidityTypes.STORAGE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.DELETE_OPERATOR, KEYWORD);

        // Number unit keywords
        attributesKeyMap.put(SolidityTypes.WEI, KEYWORD);
        attributesKeyMap.put(SolidityTypes.FINNEY, KEYWORD);
        attributesKeyMap.put(SolidityTypes.SZABO, KEYWORD);
        attributesKeyMap.put(SolidityTypes.ETHER, KEYWORD);
        attributesKeyMap.put(SolidityTypes.SECONDS, KEYWORD);
        attributesKeyMap.put(SolidityTypes.MINUTES, KEYWORD);
        attributesKeyMap.put(SolidityTypes.HOURS, KEYWORD);
        attributesKeyMap.put(SolidityTypes.DAYS, KEYWORD);
        attributesKeyMap.put(SolidityTypes.WEEKS, KEYWORD);
        attributesKeyMap.put(SolidityTypes.YEARS, KEYWORD);

        // Mixed keywords
        attributesKeyMap.put(SolidityTypes.MODIFIER, KEYWORD);
        attributesKeyMap.put(SolidityTypes.RETURN, KEYWORD);
        attributesKeyMap.put(SolidityTypes.RETURNS, KEYWORD);
        attributesKeyMap.put(SolidityTypes.EMIT, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INDEXED, KEYWORD);
        attributesKeyMap.put(SolidityTypes.NEW, KEYWORD);
        attributesKeyMap.put(SolidityTypes.PRAGMA, KEYWORD);
        attributesKeyMap.put(SolidityTypes.IMPORT, KEYWORD);
        attributesKeyMap.put(SolidityTypes.AS, KEYWORD);
        attributesKeyMap.put(SolidityTypes.FROM, KEYWORD);
        attributesKeyMap.put(SolidityTypes.USING, KEYWORD);

        // Statements keywords
        attributesKeyMap.put(SolidityTypes.IF, KEYWORD);
        attributesKeyMap.put(SolidityTypes.ELSE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.FOR, KEYWORD);
        attributesKeyMap.put(SolidityTypes.WHILE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.ASSEMBLY, KEYWORD);
        attributesKeyMap.put(SolidityTypes.DO, KEYWORD);
        attributesKeyMap.put(SolidityTypes.CONTINUE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BREAK, KEYWORD);
        attributesKeyMap.put(SolidityTypes.THROW, KEYWORD);

        // Variable types keywords
        attributesKeyMap.put(SolidityTypes.TRUE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.FALSE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.ADDRESS, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BOOL, KEYWORD);
        attributesKeyMap.put(SolidityTypes.STRING, KEYWORD);
        attributesKeyMap.put(SolidityTypes.VAR, KEYWORD);
        attributesKeyMap.put(SolidityTypes.MAPPING, KEYWORD);
        attributesKeyMap.put(SolidityTypes.STRUCT, KEYWORD);
        attributesKeyMap.put(SolidityTypes.ENUM, KEYWORD);
        attributesKeyMap.put(SolidityTypes.LET, KEYWORD);
        attributesKeyMap.put(SolidityTypes.EVENT, KEYWORD);

        attributesKeyMap.put(SolidityTypes.INT, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT8, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT16, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT24, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT32, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT40, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT48, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT56, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT64, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT72, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT80, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT88, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT96, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT104, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT112, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT120, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT128, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT136, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT144, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT152, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT160, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT168, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT176, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT184, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT192, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT200, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT208, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT216, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT224, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT232, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT240, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT248, KEYWORD);
        attributesKeyMap.put(SolidityTypes.INT256, KEYWORD);

        attributesKeyMap.put(SolidityTypes.UINT, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT8, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT16, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT24, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT32, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT40, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT48, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT56, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT64, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT72, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT80, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT88, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT96, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT104, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT112, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT120, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT128, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT136, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT144, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT152, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT160, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT168, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT176, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT184, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT192, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT200, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT208, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT216, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT224, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT232, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT240, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT248, KEYWORD);
        attributesKeyMap.put(SolidityTypes.UINT256, KEYWORD);

        attributesKeyMap.put(SolidityTypes.BYTE, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES1, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES2, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES3, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES4, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES5, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES6, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES7, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES8, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES9, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES10, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES11, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES12, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES13, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES14, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES15, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES16, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES17, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES18, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES19, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES20, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES21, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES22, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES23, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES24, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES25, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES26, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES27, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES28, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES29, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES30, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES31, KEYWORD);
        attributesKeyMap.put(SolidityTypes.BYTES32, KEYWORD);
    }

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new SolidityLexerAdapter();
    }

    @NotNull
    @Override
    public TextAttributesKey[] getTokenHighlights(IElementType tokenType) {
        return pack(attributesKeyMap.get(tokenType));
    }
}
