package com.fooock.solidity.lang.highlighter;

import com.fooock.solidity.lang.psi.SolidityFunctionDefinition;
import com.fooock.solidity.lang.psi.SolidityModifierDefinition;
import com.fooock.solidity.lang.psi.SolidityModifierFunctionInvocation;
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
        if (!(element.isValid())) return;

        if (element instanceof SolidityFunctionDefinition) {
            SolidityFunctionDefinition functionName = (SolidityFunctionDefinition) element;
            if (functionName.getIdentifier() != null)
                highlightElement(functionName.getIdentifier(), holder, SolidityColor.FUNCTION_DEC);

        } else if (element instanceof SolidityModifierDefinition) {
            SolidityModifierDefinition modifierName = (SolidityModifierDefinition) element;
            if (modifierName.getIdentifier() != null)
                highlightElement(modifierName.getIdentifier(), holder, SolidityColor.MODIFIER_DEC);

        } else if (element instanceof SolidityModifierFunctionInvocation) {
            SolidityModifierFunctionInvocation modifierInvocation = (SolidityModifierFunctionInvocation) element;
            highlightElement(modifierInvocation.getIdentifier(), holder, SolidityColor.MODIFIER_INVOCATION);
        }
    }

    private void highlightElement(PsiElement element, AnnotationHolder holder, TextAttributesKey attr) {
        holder.createInfoAnnotation(element, null).setEnforcedTextAttributes(TextAttributes.ERASE_MARKER);
        String description = ApplicationManager.getApplication().isUnitTestMode() ? attr.getExternalName() : null;
        holder.createInfoAnnotation(element, description).setTextAttributes(attr);
    }
}
