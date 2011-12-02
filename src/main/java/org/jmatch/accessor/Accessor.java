package org.jmatch.accessor;

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public interface Accessor<I, O> {
    O access(I x);
}
