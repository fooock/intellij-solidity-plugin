package com.fooock.solidity.lang.highlighter;

import com.fooock.solidity.lang.psi.SolidityFunctionName;
import com.fooock.solidity.lang.psi.SolidityModifierName;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class SolidityHighlightingAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof SolidityFunctionName) {
            SolidityFunctionName functionName = (SolidityFunctionName) element;
            highlightElement(functionName.getIdentifier(), holder, SolidityColor.FUNCTION_DEC);

        } else if (element instanceof SolidityModifierName) {
            SolidityModifierName modifierName = (SolidityModifierName) element;
            highlightElement(modifierName.getIdentifier(), holder, SolidityColor.MODIFIER_DEC);
        }
    }

    private void highlightElement(PsiElement element, AnnotationHolder holder, TextAttributesKey attr) {
        holder.createInfoAnnotation(element, null).setEnforcedTextAttributes(TextAttributes.ERASE_MARKER);
        String description = ApplicationManager.getApplication().isUnitTestMode() ? attr.getExternalName() : null;
        holder.createInfoAnnotation(element, description).setTextAttributes(attr);
    }
}
