/*
 * Copyright 2012 Roman Kashitsyn
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.rulesdsl;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.rulesdsl.predicates.*;

import java.util.List;

import static com.google.common.collect.Lists.newArrayListWithExpectedSize;

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public class Selectors {

    public static class OngoingFunctionPredicate<I, O> {
        private final Function<I, O> f;
        private OngoingFunctionPredicate(Function<I, O> f) {
            this.f = f;
        }
        public Selector<I> output(final Predicate<? super O> valuePredicate) {
            return new AbstractSelector<I>() {
                public boolean matches(I i) {
                    return i != null && valuePredicate.apply(f.apply(i));
                }
            };
        }
    }

    private Selectors() {}

    /* Stateless predicates */

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

    /* Logical predicates */
    
    public static <T> Selector<T> not(Selector<T> selector) {
        return new NotSelector<T>(selector);
    }
    
    public static <T> Selector<T> allOf(Iterable<Selector<? super T>> selectors) {
        return new AllOfSelector<T>(selectors);
    }

    public static <T> Selector<T> allOf(Selector<? super T> s1, Selector<? super T> s2) {
        List<Selector<? super T>> selectors = newArrayListWithExpectedSize(2);
        selectors.add(s1);
        selectors.add(s2);
        return allOf(selectors);
    }

    public static <T> Selector<T> anyOf(Iterable<Selector<? super T>> selectors) {
        return new AnyOfSelector<T>(selectors);
    }

    public static <T> Selector<T> anyOf(Selector<? super T> s1, Selector<? super T> s2) {
        List<Selector<? super T>> selectors = newArrayListWithExpectedSize(2);
        selectors.add(s1);
        selectors.add(s2);
        return anyOf(selectors);
    }
    
    public static <T> Selector<T> nonOf(Iterable<? extends Selector<? super T>> selectors) {
        return new NonOfSelector<T>(selectors);
    }
    
    public static <T> Selector<T> nonOf(Selector<? super T> s1, Selector<? super T> s2) {
        List<Selector<? super T>> selectors = newArrayListWithExpectedSize(2);
        selectors.add(s1);
        selectors.add(s2);
        return nonOf(selectors);
    }

    /* Predicates related to functions */

    public static <I, O> OngoingFunctionPredicate<I, O> when(Function<I, O> function) {
        return new OngoingFunctionPredicate<I, O>(function);
    }
}
