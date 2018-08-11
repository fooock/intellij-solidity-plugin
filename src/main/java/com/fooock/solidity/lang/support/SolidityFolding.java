package com.fooock.solidity.lang.support;

import com.fooock.solidity.lang.psi.SolidityTypes;
import com.intellij.lang.ASTNode;
import com.intellij.lang.folding.FoldingBuilder;
import com.intellij.lang.folding.FoldingDescriptor;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.tree.IElementType;
import com.intellij.psi.tree.TokenSet;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class SolidityFolding implements FoldingBuilder {
    private static final int MIN = 1;
    private static final FoldingDescriptor[] TYPE_ARRAY_FOLDING_DESCRIPTOR = new FoldingDescriptor[0];

    @NotNull
    @Override
    public FoldingDescriptor[] buildFoldRegions(@NotNull ASTNode node, @NotNull Document document) {
        List<FoldingDescriptor> descriptors = new ArrayList<>();
        getFoldDescriptors(node, descriptors);
        return descriptors.toArray(TYPE_ARRAY_FOLDING_DESCRIPTOR);
    }

    private void getFoldDescriptors(ASTNode node, List<FoldingDescriptor> descriptors) {
        IElementType elementType = node.getElementType();
        // Find list of imports
        if (elementType == SolidityTypes.IMPORT_LIST) {
            ASTNode[] commentChildren = node.getChildren(TokenSet.create(SolidityTypes.IMPORT_DIRECTIVE));
            if (commentChildren.length > MIN) {
                // We need to get the end offset of the first element of the import list.
                // in this case, first get from node: directive -> psiElement -> textRange + 1 (white space)
                int start = node.getFirstChildNode().getFirstChildNode().getTextRange().getEndOffset() + 1;
                TextRange range = TextRange.create(start, node.getTextRange().getEndOffset());
                descriptors.add(new FoldingDescriptor(node, range));
            }
        }
        // Find all comment regions
        if (elementType == SolidityTypes.COMMENT) {
            // At this time we don't allow folding line comments
            // see issue #2 for details.
            if (!node.getText().startsWith(SolidityCommenter.LINE_COMMENT))
                descriptors.add(new FoldingDescriptor(node, node.getTextRange()));
        }
        // Find contract body and contract blocks
        if (elementType == SolidityTypes.CONTRACT_BLOCK || elementType == SolidityTypes.MAIN_BLOCK)
            descriptors.add(new FoldingDescriptor(node, node.getTextRange()));

        // Find all child elements
        for (ASTNode child : node.getChildren(null)) {
            getFoldDescriptors(child, descriptors);
        }
    }

    @Nullable
    @Override
    public String getPlaceholderText(@NotNull ASTNode node) {
        IElementType elementType = node.getElementType();
        // Placeholder for import list
        if (elementType == SolidityTypes.IMPORT_LIST) return "...";
        // Placeholder for block comments
        if (elementType == SolidityTypes.COMMENT) return "/**...*/";
        // Placeholder for contract structure and contract blocks
        if (elementType == SolidityTypes.CONTRACT_BLOCK || elementType == SolidityTypes.MAIN_BLOCK) return "{...}";
        return null;
    }

    @Override
    public boolean isCollapsedByDefault(@NotNull ASTNode node) {
        return false;
    }
}
