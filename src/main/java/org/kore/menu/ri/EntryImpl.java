/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.menu.ri;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import org.kore.menu.api.EmptyEntryGroup;
import org.kore.menu.api.EntryGroup;
import org.kore.menu.api.EntryTask;
import org.kore.menu.api.EntryUID;
import org.kore.menu.api.NullEntry;
import org.kore.menu.api.security.Authorization;

/**
 *
 * @author Konrad Renner
 */
public class EntryImpl extends AbstractEntry {

    private EntryImpl(EntryUID uid, EntryUID parent, EntryGroup children, Set<EntryTask> mappedTasks, String displayKey, String path, String errorPath, Set<Authorization> auth) {
        super(uid, parent, children, mappedTasks, displayKey, path, errorPath, auth);
    
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
    public static final class Builder {

        private final EntryUID uid;
        private EntryUID parent;
        private EntryGroup children;
        private Set<EntryTask> mappedTasks;
        private String displayKey;
        private String path;
        private String errorPath;
        private Set<Authorization> auths;

        public Builder(final EntryUID uid) {
            Objects.requireNonNull(uid);
            this.uid = uid;

            this.parent = new NullEntry().getUID();
            this.children = new EmptyEntryGroup();
            this.auths = Collections.EMPTY_SET;
            this.displayKey = "";
            this.errorPath = "";
            this.mappedTasks = Collections.EMPTY_SET;
            this.path = "";

        }

        public Builder parent(EntryUID value) {
            this.parent = value;
            return this;
        }

        public Builder children(EntryGroup value) {
            this.children = value;
            return this;
        }

        public Builder displayKey(String value) {
            this.displayKey = value;
            return this;
        }

        public Builder errorPath(String value) {
            this.errorPath = value;
            return this;
        }

        public Builder mappedTasks(Set<EntryTask> value) {
            this.mappedTasks = value;
            return this;
        }

        public Builder path(String value) {
            this.path = value;
            return this;
        }

        public EntryImpl build() {
            return new EntryImpl(uid, parent, children, mappedTasks, displayKey, path, errorPath, auths);
        }
    }
}
