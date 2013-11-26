/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.menu.ri;

import java.io.Serializable;
import java.util.Objects;
import org.kore.menu.api.Entry;
import org.kore.menu.api.NavigationPath;

/**
 *
 * @author Konrad Renner
 */
public class NavigationPathImpl implements NavigationPath, Serializable {

    private final String navigationString;
    private final Entry mappedEntry;
    private final NavigationPath errorPath;

    public NavigationPathImpl(String navigationString, Entry mappedEntry, NavigationPath errorPath) {
        Objects.requireNonNull(navigationString, "navigationString must not be null");
        Objects.requireNonNull(mappedEntry, "mappedEntry must not be null");
        Objects.requireNonNull(errorPath, "errorPath must not be null");
        this.navigationString = navigationString;
        this.mappedEntry = mappedEntry;
        this.errorPath = errorPath;
    }


    @Override
    public String asString() {
        return navigationString;
    }

    @Override
    public NavigationPath getErrorPath() {
        return errorPath;
    }

    @Override
    public Entry getMappedEntry() {
        return mappedEntry;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.mappedEntry != null ? this.mappedEntry.hashCode() : 0);
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
        final NavigationPathImpl other = (NavigationPathImpl) obj;
        if (this.mappedEntry != other.mappedEntry && (this.mappedEntry == null || !this.mappedEntry.equals(other.mappedEntry))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "NavigationPathImpl{" + "navigationString=" + navigationString + ", mappedEntry=" + mappedEntry + ", errorPath=" + errorPath + '}';
    }
}
