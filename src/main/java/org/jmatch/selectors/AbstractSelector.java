package org.jmatch.selectors;

import org.jmatch.Selector;

/**
 * @author Roman Kashitsyn
 */
public abstract class AbstractSelector<E> implements Selector<E> {
    
    public boolean apply(E e) {
        return matches(e);
    }
}
