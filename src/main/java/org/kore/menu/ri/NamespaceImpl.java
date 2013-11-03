/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.kore.menu.ri;

import java.io.Serializable;
import org.kore.menu.api.Namespace;

/**
 *
 * @author Konrad Renner
 */
public class NamespaceImpl implements Namespace, Serializable {

    private final String name;

    public NamespaceImpl(String name) {
        this.name = name;
    }


    @Override
    public String getName() {
        return this.name;
    }
}
