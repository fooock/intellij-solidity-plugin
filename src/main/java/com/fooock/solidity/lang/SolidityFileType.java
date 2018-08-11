package com.fooock.solidity.lang;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * Solidity file type
 */
public class SolidityFileType extends LanguageFileType {
    public static final SolidityFileType INSTANCE = new SolidityFileType();

    /**
     * Creates a language file type for the {@link SolidityLang} language.
     */
    private SolidityFileType() {
        super(SolidityLang.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Solidity";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Solidity language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "sol";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return SolidityIcons.ICON_SOLIDITY_LANG;
    }
}
