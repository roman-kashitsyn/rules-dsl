package org.jmatch.rules;

import org.jmatch.Rule;
import org.jmatch.Selector;

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public abstract class AbstractRule<I, O> implements Rule<I, O> {
    
    private final Selector<? super I> selector;
    
    public AbstractRule(Selector<? super I> selector) {
        this.selector = selector;
    }
    
    public O apply(I x) {
        if( !isDefinedAt(x) ) {
            throw new RuleNotApplicableException("Input " + x + " does not match " + selector);
        }
        return getValue(x);
    }
    
    public boolean isDefinedAt(I x) {
        return selector.matches(x);
    }
    
    protected abstract O getValue(I input);
    
    protected Selector<? super I> getSelector() {
        return selector;
    }
}
