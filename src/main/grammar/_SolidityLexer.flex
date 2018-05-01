package com.fooock.solidity.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.fooock.solidity.lang.psi.SolidityTypes.*;

%%

%{
  public _SolidityLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _SolidityLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

SPACE=[ \t\n\x0B\f\r]+
IDENTIFIER=[a-zA-Z_$][a-zA-Z_$0-9]*
PRAGMA_VERSION=[0-9].[0-9].[0-9]+

%%
<YYINITIAL> {
  {WHITE_SPACE}         { return WHITE_SPACE; }

  "{"                   { return LBRACE; }
  "}"                   { return RBRACE; }
  "["                   { return LBRACK; }
  "]"                   { return RBRACK; }
  "("                   { return LPAREN; }
  ")"                   { return RPAREN; }
  ":"                   { return COLON; }
  ";"                   { return SEMICOLON; }
  ","                   { return COMMA; }
  "=="                  { return EQ; }
  "="                   { return ASSIGN; }
  "!="                  { return NOT_EQ; }
  "!"                   { return NOT; }
  "++"                  { return PLUS_PLUS; }
  "+="                  { return PLUS_ASSIGN; }
  "+"                   { return PLUS; }
  "--"                  { return MINUS_MINUS; }
  "-="                  { return MINUS_ASSIGN; }
  "-"                   { return MINUS; }
  "||"                  { return COND_OR; }
  "|="                  { return BIT_OR_ASSIGN; }
  "&&"                  { return COND_AND; }
  "&="                  { return BIT_AND_ASSIGN; }
  "&"                   { return BIT_AND; }
  "|"                   { return BIT_OR; }
  "<<="                 { return SHIFT_LEFT_ASSIGN; }
  "<<"                  { return SHIFT_LEFT; }
  "<="                  { return LESS_OR_EQUAL; }
  "<"                   { return LESS; }
  "^="                  { return BIT_XOR_ASSIGN; }
  "^"                   { return BIT_XOR; }
  "*="                  { return MUL_ASSIGN; }
  "*"                   { return MUL; }
  "/="                  { return QUOTIENT_ASSIGN; }
  "/"                   { return QUOTIENT; }
  "%="                  { return REMAINDER_ASSIGN; }
  "%"                   { return REMAINDER; }
  ">>="                 { return SHIFT_RIGHT_ASSIGN; }
  ">>"                  { return SHIFT_RIGHT; }
  ">="                  { return GREATER_OR_EQUAL; }
  ">"                   { return GREATER; }
  "pragma"              { return PRAGMA_NAME; }

  {SPACE}               { return SPACE; }
  {IDENTIFIER}          { return IDENTIFIER; }
  {PRAGMA_VERSION}      { return PRAGMA_VERSION; }

}

[^] { return BAD_CHARACTER; }
