# About grammar
Official Solidity `grammar.txt` found in the [official repo](https://github.com/ethereum/solidity/blob/develop/docs/grammar.txt)

## Generating `_SolidityLexer.flex`
The file [`_SolidityLexer.flex`](_SolidityLexer.flex) was generated manually using the 
`Generate JFlex Lexer` context menu option from the [SolidityParser.bnf](SolidityParser.bnf)
file.

For each change in the *bnf* file, we need to generate a new *.flex*. After
this, a manual change is needed:

```diff
- package com.fooock.solidity.lang.parser;
+ package com.fooock.solidity.lang.lexer;
```
