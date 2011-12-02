package org.jmatch.rules;

import org.jmatch.Rule;
import org.jmatch.Selector;

import java.util.concurrent.Callable;

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public class CallableRule<I, O> extends AbstractRule<I, O> {
    
    private final Callable<? extends O> callable;
    
    public CallableRule(Selector<? super I> selector, Callable<? extends O> callable) {
        super(selector);
        this.callable = callable;
    }
    
    public O getValue(I input) {
        try {
            return callable.call();
        } catch (Exception e) {
            throw new RuntimeException("Can not apply rule", e);
        }
    }
    
    @Override public String toString() {
        return "{" + getSelector() + " -> " + callable + "}";
    }
}
