package com.fooock.solidity.lang.usage;

import com.fooock.solidity.lang.psi.SolidityContractDirective;
import com.fooock.solidity.lang.psi.SolidityElement;
import com.intellij.lang.HelpID;
import com.intellij.lang.cacheBuilder.WordsScanner;
import com.intellij.lang.findUsages.FindUsagesProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 *
 */
public class SolidityFindUsageProvider implements FindUsagesProvider {
    private static final String EMPTY_STRING = "";

    @Nullable
    @Override
    public WordsScanner getWordsScanner() {
        return new SolidityWordScanner();
    }

    @Override
    public boolean canFindUsagesFor(@NotNull PsiElement psiElement) {
        return psiElement instanceof SolidityElement;
    }

    @Nullable
    @Override
    public String getHelpId(@NotNull PsiElement psiElement) {
        return HelpID.FIND_OTHER_USAGES;
    }

    @NotNull
    @Override
    public String getType(@NotNull PsiElement element) {
        if (element instanceof SolidityContractDirective) {
            return "Contract directive";
        }
        return EMPTY_STRING;
    }

    @NotNull
    @Override
    public String getDescriptiveName(@NotNull PsiElement element) {
        if (element instanceof SolidityContractDirective) {
            SolidityContractDirective val = (SolidityContractDirective) element;
            return val.getIdentifier().getText();
        }
        return EMPTY_STRING;
    }

    @NotNull
    @Override
    public String getNodeText(@NotNull PsiElement element, boolean useFullName) {
        if (element instanceof SolidityContractDirective) {
            SolidityContractDirective val = (SolidityContractDirective) element;
            return String.format("Contract : %s", val.getIdentifier().getText());
        }
        return EMPTY_STRING;
    }
}
