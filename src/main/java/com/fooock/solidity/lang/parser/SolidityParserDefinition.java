package com.fooock.solidity.lang.parser;

import com.fooock.solidity.lang.SolidityLang;
import com.fooock.solidity.lang.lexer.SolidityLexerAdapter;
import com.fooock.solidity.lang.psi.SolidityFile;
import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lang.PsiParser;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IFileElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;

/**
 * Define the parser for the Solidity language
 */
public class SolidityParserDefinition implements ParserDefinition {

    private static final TokenSet WHITE_SPACE = TokenSet.create(TokenType.WHITE_SPACE);
    private static final TokenSet COMMENTS = TokenSet.create(SolidityTypes.COMMENT);

    private static final IFileElementType FILE = new IFileElementType(SolidityLang.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new SolidityLexerAdapter();
    }

    @Override
    public PsiParser createParser(Project project) {
        return new SolidityParser();
    }

    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return SolidityTypes.Factory.createElement(node);
    }

    @Override
    public PsiFile createFile(FileViewProvider viewProvider) {
        return new SolidityFile(viewProvider);
    }

    @Override
    public SpaceRequirements spaceExistanceTypeBetweenTokens(ASTNode left, ASTNode right) {
        return SpaceRequirements.MAY;
    }

    @NotNull
    @Override
    public TokenSet getWhitespaceTokens() {
        return WHITE_SPACE;
    }
}
