package org.jmatch.rules;

import com.google.common.base.Function;
import org.jmatch.Selector;

/**
 * @author Roman Kashitsyn
 */
public class FuncRule<I, O> extends AbstractRule<I, O> {
    
    private final Function<I, O> func;
    
    public FuncRule(Selector<? super I> selector, Function<I, O> func) {
        super(selector);
        this.func = func;
    }
    
    @Override protected O getValue(I input) {
        return func.apply(input);
    }
    
    @Override public String toString() {
        return "{" + getSelector() + " -> " + func + "}";
    }

}
