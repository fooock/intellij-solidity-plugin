package com.fooock.solidity.lang.util;

import com.fooock.solidity.lang.SolidityFileType;
import com.fooock.solidity.lang.psi.SolidityEventDefinition;
import com.fooock.solidity.lang.psi.SolidityFile;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 */
public class SolidityUtils {

    private SolidityUtils() {
    }

    @NotNull
    public static List<SolidityEventDefinition> findEventDefinitions(Project project, String name) {
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(
                SolidityFileType.INSTANCE, GlobalSearchScope.allScope(project));

        List<SolidityEventDefinition> eventDefinitions = new ArrayList<>();
        for (VirtualFile virtualFile : virtualFiles) {
            SolidityFile file = (SolidityFile) PsiManager.getInstance(project).findFile(virtualFile);

            SolidityEventDefinition[] events = PsiTreeUtil.getChildrenOfType(file, SolidityEventDefinition.class);
            if (events == null || events.length == 0) continue;

            // check event name
            for (SolidityEventDefinition event : events) {
                PsiElement identifier = event.getIdentifier();

                if (identifier == null) continue;
                if (identifier.getText().equals(name)) eventDefinitions.add(event);
            }
        }
        return eventDefinitions;
    }
}
