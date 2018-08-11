package com.fooock.solidity.lang.support;

import com.intellij.lang.Commenter;
import org.jetbrains.annotations.Nullable;

/**
 * Comment support for Solidity
 */
public class SolidityCommenter implements Commenter {
    static final String LINE_COMMENT = "//";

    @Nullable
    @Override
    public String getLineCommentPrefix() {
        return LINE_COMMENT;
    }

    @Nullable
    @Override
    public String getBlockCommentPrefix() {
        return "/**";
    }

    @Nullable
    @Override
    public String getBlockCommentSuffix() {
        return "*/";
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentPrefix() {
        return null;
    }

    @Nullable
    @Override
    public String getCommentedBlockCommentSuffix() {
        return null;
    }
}
