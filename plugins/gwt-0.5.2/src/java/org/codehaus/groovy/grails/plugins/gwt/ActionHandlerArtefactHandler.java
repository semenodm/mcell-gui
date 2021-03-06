/*
 * Copyright 2007 Peter Ledbrook.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 *
 * Modified 2009 Bradley Beddoes, Intient Pty Ltd, Ported to Apache Ki
 * Modified 2009 Kapil Sachdeva, Gemalto Inc, Ported to Apache Shiro
 */
package org.codehaus.groovy.grails.plugins.gwt;

import org.codehaus.groovy.grails.commons.ArtefactHandlerAdapter;

/**
 * Manages the GWT action handler artifact type. Action handlers are
 * the server-side components that process the actions (or commands)
 * that come from the GWT client. Actions are equivalent to commands
 * in the Command pattern.
 */
public final class ActionHandlerArtefactHandler extends ArtefactHandlerAdapter {
    public static final String TYPE = "ActionHandler";

    public ActionHandlerArtefactHandler() {
        super(TYPE, ActionHandlerGrailsClass.class, DefaultActionHandlerGrailsClass.class, null);
    }

    public boolean isArtefactClass(Class clazz) {
        return clazz != null && clazz.getName().endsWith(TYPE);
    }
}
