package org.jmatch.selectors;

import org.jmatch.Selector;

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
