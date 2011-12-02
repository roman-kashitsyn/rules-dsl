package org.jmatch;

import com.google.common.base.Predicate;

/**
 * Selector interface present simple generic matcher.
 * @param <E> type to match
 * @author Roman Kashitsyn
 */
public interface Selector<E> extends Predicate<E> {

    /**
     * Check does element matches the rules incapsulated into selectors.
     * @param e element to match
     * @return true if element
     */
    boolean matches(E e);
}
