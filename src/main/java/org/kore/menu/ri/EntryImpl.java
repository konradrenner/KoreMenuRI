/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.menu.ri;

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
public class EntryImpl implements Entry {

    @Override
    public Type getType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntryUID getUID() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Authorization> getRequiredAuthorization() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean controlAuthorizations(SecurityInspector inspector, SecurityContext context) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntryUID getParent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public EntryGroup getChildren() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<EntryTask> getMappedTasks() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean executeTask(EntryUID taskid, SecurityContext context, SecurityInspector inspector) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDisplayKey() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public NavigationPath getNavigationPath() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int compareTo(Entry o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
