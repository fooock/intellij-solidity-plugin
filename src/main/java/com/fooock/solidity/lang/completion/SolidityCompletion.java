package com.fooock.solidity.lang.completion;

import com.intellij.codeInsight.completion.CompletionContributor;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 * Solidity code completion
 */
public class SolidityCompletion extends CompletionContributor {

    @Override
    public boolean invokeAutoPopup(@NotNull PsiElement position, char typeChar) {
        // show popup automatically when access member
        return typeChar == '.';
    }
}
