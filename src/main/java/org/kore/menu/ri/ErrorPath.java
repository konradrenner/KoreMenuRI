/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.menu.ri;

import org.kore.menu.api.Entry;
import org.kore.menu.api.NullNavigationPath;

/**
 *
 * @author Konrad Renner
 */
public class ErrorPath extends NavigationPathImpl {

    public ErrorPath(String navigationString, Entry mappedEntry) {
        super(navigationString, mappedEntry, new NullNavigationPath());
    }

    @Override
    public String toString() {
        return "ErrorPath{" + super.toString() + '}';
    }
}
