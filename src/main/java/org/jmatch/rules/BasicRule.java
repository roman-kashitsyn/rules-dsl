package org.jmatch.rules;

import org.jmatch.Selector;

/**
 * @author Roman Kashitsyn
 */
public class BasicRule<I, O> extends AbstractRule<I, O> {
    
    private final O value;

    public BasicRule(Selector<? super I> selector, O value) {
        super(selector);
        this.value = value;
    }

    protected O getValue(I input) {
        return value;
    }
}
