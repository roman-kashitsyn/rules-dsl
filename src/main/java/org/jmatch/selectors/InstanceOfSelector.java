package org.jmatch.selectors;

/**
 * @author Roman Kashitsyn
 */
public class InstanceOfSelector extends AbstractSelector<Object> {
    
    private final Class<?> clazz;
    
    public InstanceOfSelector(Class<?> clazz) {
        this.clazz = clazz;
    }
    
    public boolean matches(Object o) {
        return clazz.isInstance(o);
    }
    
    @Override public String toString() {
        return "instanceOf(" + clazz.getSimpleName() + ")";
    }
}
