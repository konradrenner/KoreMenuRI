/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.menu.ri;

import org.kore.menu.api.EntryUID;
import org.kore.menu.api.Namespace;

/**
 *
 * @author Konrad Renner
 */
public class EntryUIDImpl implements EntryUID {

    private final Namespace namespace;
    private final String id;
    private final String sorting;

    public EntryUIDImpl(Namespace namespace, String id, String sorting) {
        this.namespace = namespace;
        this.id = id;
        this.sorting = sorting;
    }

    @Override
    public Namespace getNamespace() {
        return this.namespace;
    }

    @Override
    public String getIdentifierString() {
        return this.id;
    }

    @Override
    public String getSortingKey() {
        return this.sorting;
    }

    @Override
    public int compareTo(EntryUID o) {
        return getSortingKey().compareTo(o.getSortingKey());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + (this.namespace != null ? this.namespace.hashCode() : 0);
        hash = 67 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 67 * hash + (this.sorting != null ? this.sorting.hashCode() : 0);
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
        final EntryUIDImpl other = (EntryUIDImpl) obj;
        if (this.namespace != other.namespace && (this.namespace == null || !this.namespace.equals(other.namespace))) {
            return false;
        }
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        if ((this.sorting == null) ? (other.sorting != null) : !this.sorting.equals(other.sorting)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntryUIDImpl{id=" + id + ", namespace=" + namespace + ", sorting=" + sorting + '}';
    }
}
