package org.jmatch.selectors;

import org.jmatch.Selector;

/**
 * @author Roman Kashitsyn
 */
public class NotSelector<E> extends AbstractSelector<E> {
    
    private final Selector<E> selector;
    
    public NotSelector(Selector<E> selector) {
        this.selector = selector;
    }
    
    public boolean matches(E e) {
        return !selector.matches(e);
    }

    @Override
    public String toString() {
        return "not[" + selector.toString() + "]";
    }
}
