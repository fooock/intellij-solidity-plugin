package com.fooock.solidity.lang.psi;

import com.fooock.solidity.lang.SolidityFileType;
import com.fooock.solidity.lang.SolidityLang;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

/**
 * Solidity file
 */
public class SolidityFile extends PsiFileBase {

    public SolidityFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, SolidityLang.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return SolidityFileType.INSTANCE;
    }
}
