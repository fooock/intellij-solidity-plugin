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

## Notes
Notes about how I implementes the [`SolidityParser.bnf`](SolidityParser.bnf)

* `pragma` support `^` and much more complex rules like those used by
[npm](https://docs.npmjs.com/misc/semver). At this moment: `>`, `>=`, 
`<`, `<=` and `=`.
* See [this document](https://github.com/ethereum/solidity/blob/develop/docs/miscellaneous.rst) for 
order of precedence of operators
* See [Solidity types](https://solidity.readthedocs.io/en/latest/types.html)
* See [units and globally available variables](https://solidity.readthedocs.io/en/latest/units-and-global-variables.html)