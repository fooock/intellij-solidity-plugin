package com.fooock.solidity.lang.support;

import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SolidityFolding implements FoldingBuilder {
    private static final FoldingDescriptor[] TYPE_ARRAY_FOLDING_DESCRIPTOR = new FoldingDescriptor[0];

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode node, @NotNull Document document) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        getDescriptors(node, descriptors);
        return descriptors.toArray(TYPE_ARRAY_FOLDING_DESCRIPTOR);
    }

    private void getDescriptors(ASTNode node, List<FoldingDescriptor> descriptors) {
        IElementType elementType = node.getElementType();
        // Find all comment regions
        if (elementType == SolidityTypes.COMMENT) {
            descriptors.add(new FoldingDescriptor(node, node.getTextRange()));
        }
        // Find all child elements
        for (ASTNode child : node.getChildren(null)) {
            getDescriptors(child, descriptors);
        }
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        IElementType elementType = node.getElementType();
        if (elementType == SolidityTypes.COMMENT)
            // return the same string used by IntelliJ to represent comments
            return "/**...*/";
        return null;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
