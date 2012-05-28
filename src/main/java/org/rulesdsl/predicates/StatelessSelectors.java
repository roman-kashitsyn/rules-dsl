/*
 * Copyright 2012 Roman Kashitsyn
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.rulesdsl.predicates;

import org.rulesdsl.Selector;

/**
 * @author Roman Kashitsyn
 */
public enum StatelessSelectors implements Selector<Object> {
    
    Anything {
        public boolean matches(Object o) {
            return true;
        }
        @Override public String toString() {
            return "anything";
        }
    },
    Null {
        public boolean matches(Object o) {
            return o == null;
        }
        
        @Override public String toString() {
            return "null?";
        }
    },
    NotNull {
        public boolean matches(Object o) {
            return o != null; 
        }
        
        @Override public String toString() {
            return "notNull?";
        }
    };
    
    public boolean apply(Object o) {
        return matches(o);
    }
}
