package org.jmatch;

import com.google.common.base.Function;

/**
 * @author Roman Kashitsyn
 */
public interface Rule<I, O> extends Function<I, O> {
    boolean isDefinedAt(I x);
}
