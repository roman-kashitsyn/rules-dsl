package org.jmatch;

import com.google.common.base.Function;
import org.jmatch.rules.*;

import java.util.concurrent.Callable;

/**
 * @author Roman Kashitsyn
 */
public class Rules {

    private Rules() {}
    
    public static <I, O> Rule<I, O> bind(Selector<? super I> selector, O value) {
        return new BasicRule<I, O>(selector, value);
    }
    
    public static <I, O> Rule<I, O> bind(Selector<? super I> selector, Function<I, O> func) {
        return new FuncRule<I, O>(selector, func);
    }

    public static <I, O> Rule<I, O> bind(Selector<? super I> selector, Callable<? extends O> callable) {
        return new CallableRule<I, O>(selector, callable);
    }
}
