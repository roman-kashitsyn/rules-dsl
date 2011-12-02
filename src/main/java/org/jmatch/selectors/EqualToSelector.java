package org.jmatch.selectors;

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public class EqualToSelector extends AbstractSelector<Object> {
    private final Object matchAgainst;
    
    public EqualToSelector(Object matchAgainst) {
        this.matchAgainst = matchAgainst;
    } 
    
    public boolean matches(Object o) {
        return matchAgainst.equals(o);
    }

    @Override public String toString() {
        return "equalTo(" + matchAgainst + ")";
    }
}
