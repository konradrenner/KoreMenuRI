/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.menu.ri;

import java.util.Set;
import org.kore.menu.api.EntryGroup;
import org.kore.menu.api.EntryTask;
import org.kore.menu.api.EntryUID;
import org.kore.menu.api.NavigationPath;
import org.kore.menu.api.security.Authorization;

/**
 *
 * @author Konrad Renner
 */
public class EntryImpl extends AbstractEntry {

    public EntryImpl(EntryUID uid, EntryUID parent, EntryGroup children, Set<EntryTask> mappedTasks, String displayKey, NavigationPath path, Set<Authorization> auth) {
        super(uid, parent, children, mappedTasks, displayKey, path, auth);
    
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + (getUID() != null ? getUID().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EntryImpl other = (EntryImpl) obj;
        if (getUID() != other.getUID() && (getUID() == null || !getUID().equals(other.getUID()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntryImpl{" + "uid=" + getUID() + ", parent=" + getParent() + ", children=" + getChildren() + ", mappedTasks=" + getMappedTasks() + ", displayKey=" + getDisplayKey() + ", path=" + getNavigationPath() + ", auths=" + getRequiredAuthorization() + '}';
    }
}
