package com.fooock.solidity.lang.completion;

import com.fooock.solidity.lang.psi.SolidityImportDirective;
import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.codeInsight.completion.CompletionType;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.patterns.PsiElementPattern;
import com.intellij.psi.PsiElement;

/**
 * Solidity code completion
 */
public class SolidityCompletionContributor extends CompletionContributor {

    public SolidityCompletionContributor() {
        extend(CompletionType.BASIC, imports(), new ImportCompletionProvider());
    }

    private PsiElementPattern.Capture<PsiElement> imports() {
        return PlatformPatterns.psiElement(SolidityTypes.STRING_LITERAL)
                .withSuperParent(2, SolidityImportDirective.class);
    }
}
