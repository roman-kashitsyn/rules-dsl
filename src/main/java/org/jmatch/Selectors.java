package org.jmatch;

import org.jmatch.selectors.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public class Selectors {

    private Selectors() {}

    /* Stateless selectors */

    public static <T> Selector<T> is(Selector<T> s) {
        return s;
    }

    public static Selector<Object> isNull() {
        return StatelessSelectors.Null;
    }

    public static Selector<Object> isNotNull() {
        return StatelessSelectors.NotNull;
    }
    
    public static Selector<Object> anything() {
        return StatelessSelectors.Anything;
    }
    
    public static Selector<Object> equalTo(Object o) {
        return new EqualToSelector(o);
    }

    /* Logical selectors */
    
    public static <T> Selector<T> not(Selector<T> selector) {
        return new NotSelector<T>(selector);
    }
    
    public static <T> Selector<T> allOf(Iterable<Selector<? super T>> selectors) {
        return new AllOfSelector<T>(selectors);
    }

    public static <T> Selector<T> allOf(Selector<? super T> s1, Selector<? super T> s2) {
        List<Selector<? super T>> selectors = new ArrayList<Selector<? super T>>(2);
        selectors.add(s1);
        selectors.add(s2);
        return new AllOfSelector<T>(selectors);
    }

    public static <T> Selector<T> anyOf(Iterable<Selector<? super T>> selectors) {
        return new AnyOfSelector<T>(selectors);
    }

    public static <T> Selector<T> anyOf(Selector<? super T> s1, Selector<? super T> s2) {
        List<Selector<? super T>> selectors = new ArrayList<Selector<? super T>>(2);
        selectors.add(s1);
        selectors.add(s2);
        return new AnyOfSelector<T>(selectors);
    }
}
