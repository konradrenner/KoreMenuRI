/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.menu.ri;

import java.io.Serializable;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import org.kore.menu.api.Entry;
import org.kore.menu.api.EntryGroup;
import org.kore.menu.api.EntryTask;
import org.kore.menu.api.EntryUID;
import org.kore.menu.api.NavigationPath;
import org.kore.menu.api.security.Authorization;
import org.kore.menu.api.security.SecurityContext;
import org.kore.menu.api.security.SecurityInspector;

/**
 *
 * @author Konrad Renner
 */
public abstract class AbstractEntry implements Entry, Serializable {

    private final EntryUID uid;
    private final EntryUID parent;
    private final EntryGroup children;
    private final Set<EntryTask> mappedTasks;
    private final String displayKey;
    private final NavigationPath path;
    private final Set<Authorization> auths;

    public AbstractEntry(EntryUID uid, EntryUID parent, EntryGroup children, Set<EntryTask> mappedTasks, String displayKey, NavigationPath path, Set<Authorization> auth) {
        Objects.requireNonNull(uid, "uid must not be null");
        Objects.requireNonNull(parent, "parent must not be null");
        Objects.requireNonNull(children, "children must not be null");
        Objects.requireNonNull(mappedTasks, "mappedTasks must not be null");
        Objects.requireNonNull(displayKey, "displayKey must not be null");
        Objects.requireNonNull(path, "path must not be null");
        Objects.requireNonNull(auth, "auth must not be null");
        this.uid = uid;
        this.parent = parent;
        this.children = children;
        this.mappedTasks = Collections.unmodifiableSet(mappedTasks);
        this.displayKey = displayKey;
        this.path = path;
        this.auths = Collections.unmodifiableSet(auth);
    }

    @Override
    public Type getType() {
        return Entry.Type.ENTRY;
    }

    @Override
    public EntryUID getUID() {
        return this.uid;
    }

    @Override
    public Set<Authorization> getRequiredAuthorization() {
        return this.auths;
    }

    @Override
    public boolean controlAuthorizations(SecurityInspector inspector, SecurityContext context) {
        try {
            inspector.inspect(context, this);
            return true;
        } catch (SecurityException e) {
            return false;
        }
    }

    @Override
    public EntryUID getParent() {
        return this.parent;
    }

    @Override
    public EntryGroup getChildren() {
        return this.children;
    }

    @Override
    public Set<EntryTask> getMappedTasks() {
        return this.mappedTasks;
    }

    @Override
    public boolean executeTask(EntryUID taskid, SecurityContext context, SecurityInspector inspector) {
        EntryTask task = null;
        for (EntryTask tasc : getMappedTasks()) {
            if (tasc.getUID().equals(taskid)) {
                task = tasc;
                break;
            }
        }

        if (task == null || !task.controlAuthorizations(inspector, context)) {
            return false;
        }

        task.execute(context, inspector);
        return true;
    }

    @Override
    public String getDisplayKey() {
        return this.displayKey;
    }

    @Override
    public NavigationPath getNavigationPath() {
        return this.path;
    }

    @Override
    public int compareTo(Entry o) {
        return getUID().compareTo(o.getUID());
    }
}
