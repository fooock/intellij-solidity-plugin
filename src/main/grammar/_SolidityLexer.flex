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

WHITE_SPACE=[ \t\n\x0B\f\r]+
IDENTIFIER=[a-zA-Z_$][a-zA-Z_$0-9]*
PRAGMA_VERSION=[0-9].[0-9].[0-9]+
STRING_LITERAL=(\"([^\"\r\n\\]|\\.)*\")
COMMENT=("//".*)|(\/\*([^*]|[\r\n]|(\*+([^*/]|[\r\n])))*\*+\/)
HEX_NUMBER=(0x[0-9a-fA-F]+)|(hex\"([0-9a-fA-F]+)\")
DECIMAL_NUMBER=[0-9]+(\.[0-9]*)?([eE][0-9]+)?

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
  "delete"              { return DELETE_OPERATOR; }
  "~"                   { return TILDE; }
  "**"                  { return EXPONENT; }
  "pragma"              { return PRAGMA; }
  "import"              { return IMPORT; }
  "as"                  { return AS; }
  "from"                { return FROM; }
  "is"                  { return IS; }
  "contract"            { return CONTRACT; }
  "library"             { return LIBRARY; }
  "interface"           { return INTERFACE; }
  "using"               { return USING; }
  "for"                 { return FOR; }
  "struct"              { return STRUCT; }
  "modifier"            { return MODIFIER; }
  "enum"                { return ENUM; }
  "constructor"         { return CONSTRUCTOR; }
  "public"              { return PUBLIC; }
  "private"             { return PRIVATE; }
  "function"            { return FUNCTION; }
  "external"            { return EXTERNAL; }
  "internal"            { return INTERNAL; }
  "returns"             { return RETURNS; }
  "true"                { return TRUE; }
  "false"               { return FALSE; }
  "address"             { return ADDRESS; }
  "bool"                { return BOOL; }
  "string"              { return STRING; }
  "var"                 { return VAR; }
  "mapping"             { return MAPPING; }
  "int"                 { return INT; }
  "int8"                { return INT8; }
  "int16"               { return INT16; }
  "int24"               { return INT24; }
  "int32"               { return INT32; }
  "int40"               { return INT40; }
  "int48"               { return INT48; }
  "int56"               { return INT56; }
  "int64"               { return INT64; }
  "int72"               { return INT72; }
  "int80"               { return INT80; }
  "int88"               { return INT88; }
  "int96"               { return INT96; }
  "int104"              { return INT104; }
  "int112"              { return INT112; }
  "int120"              { return INT120; }
  "int128"              { return INT128; }
  "int136"              { return INT136; }
  "int144"              { return INT144; }
  "int152"              { return INT152; }
  "int160"              { return INT160; }
  "int168"              { return INT168; }
  "int176"              { return INT176; }
  "int184"              { return INT184; }
  "int192"              { return INT192; }
  "int200"              { return INT200; }
  "int208"              { return INT208; }
  "int216"              { return INT216; }
  "int224"              { return INT224; }
  "int232"              { return INT232; }
  "int240"              { return INT240; }
  "int248"              { return INT248; }
  "int256"              { return INT256; }
  "uint"                { return UINT; }
  "uint8"               { return UINT8; }
  "uint16"              { return UINT16; }
  "uint24"              { return UINT24; }
  "uint32"              { return UINT32; }
  "uint40"              { return UINT40; }
  "uint48"              { return UINT48; }
  "uint56"              { return UINT56; }
  "uint64"              { return UINT64; }
  "uint72"              { return UINT72; }
  "uint80"              { return UINT80; }
  "uint88"              { return UINT88; }
  "uint96"              { return UINT96; }
  "uint104"             { return UINT104; }
  "uint112"             { return UINT112; }
  "uint120"             { return UINT120; }
  "uint128"             { return UINT128; }
  "uint136"             { return UINT136; }
  "uint144"             { return UINT144; }
  "uint152"             { return UINT152; }
  "uint160"             { return UINT160; }
  "uint168"             { return UINT168; }
  "uint176"             { return UINT176; }
  "uint184"             { return UINT184; }
  "uint192"             { return UINT192; }
  "uint200"             { return UINT200; }
  "uint208"             { return UINT208; }
  "uint216"             { return UINT216; }
  "uint224"             { return UINT224; }
  "uint232"             { return UINT232; }
  "uint240"             { return UINT240; }
  "uint248"             { return UINT248; }
  "uint256"             { return UINT256; }
  "byte"                { return BYTE; }
  "bytes1"              { return BYTES1; }
  "bytes2"              { return BYTES2; }
  "bytes3"              { return BYTES3; }
  "bytes4"              { return BYTES4; }
  "bytes5"              { return BYTES5; }
  "bytes6"              { return BYTES6; }
  "bytes7"              { return BYTES7; }
  "bytes8"              { return BYTES8; }
  "bytes9"              { return BYTES9; }
  "bytes10"             { return BYTES10; }
  "bytes11"             { return BYTES11; }
  "bytes12"             { return BYTES12; }
  "bytes13"             { return BYTES13; }
  "bytes14"             { return BYTES14; }
  "bytes15"             { return BYTES15; }
  "bytes16"             { return BYTES16; }
  "bytes17"             { return BYTES17; }
  "bytes18"             { return BYTES18; }
  "bytes19"             { return BYTES19; }
  "bytes20"             { return BYTES20; }
  "bytes21"             { return BYTES21; }
  "bytes22"             { return BYTES22; }
  "bytes23"             { return BYTES23; }
  "bytes24"             { return BYTES24; }
  "bytes25"             { return BYTES25; }
  "bytes26"             { return BYTES26; }
  "bytes27"             { return BYTES27; }
  "bytes28"             { return BYTES28; }
  "bytes29"             { return BYTES29; }
  "bytes30"             { return BYTES30; }
  "bytes31"             { return BYTES31; }
  "bytes32"             { return BYTES32; }
  "new"                 { return NEW; }
  "wei"                 { return WEI; }
  "finney"              { return FINNEY; }
  "szabo"               { return SZABO; }
  "ether"               { return ETHER; }
  "seconds"             { return SECONDS; }
  "minutes"             { return MINUTES; }
  "hours"               { return HOURS; }
  "days"                { return DAYS; }
  "weeks"               { return WEEKS; }
  "years"               { return YEARS; }
  "memory"              { return MEMORY; }
  "storage"             { return STORAGE; }
  "pure"                { return PURE; }
  "constant"            { return CONSTANT; }
  "view"                { return VIEW; }
  "payable"             { return PAYABLE; }
  "let"                 { return LET; }
  "event"               { return EVENT; }
  "anonymous"           { return ANONYMOUS; }
  "indexed"             { return INDEXED; }
  "if"                  { return IF; }
  "else"                { return ELSE; }
  "while"               { return WHILE; }
  "assembly"            { return ASSEMBLY; }
  "do"                  { return DO; }
  "continue"            { return CONTINUE; }
  "break"               { return BREAK; }
  "return"              { return RETURN; }
  "throw"               { return THROW; }
  "emit"                { return EMIT; }

  {WHITE_SPACE}         { return WHITE_SPACE; }
  {IDENTIFIER}          { return IDENTIFIER; }
  {PRAGMA_VERSION}      { return PRAGMA_VERSION; }
  {STRING_LITERAL}      { return STRING_LITERAL; }
  {COMMENT}             { return COMMENT; }
  {HEX_NUMBER}          { return HEX_NUMBER; }
  {DECIMAL_NUMBER}      { return DECIMAL_NUMBER; }

}

[^] { return BAD_CHARACTER; }
