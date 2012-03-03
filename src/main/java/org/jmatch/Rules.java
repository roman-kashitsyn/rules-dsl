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

package org.jmatch;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.jmatch.rules.*;

import java.util.concurrent.Callable;

/**
 * @author Roman Kashitsyn
 */
public class Rules {

    private Rules() {}
    
    public static <I, O> Rule<I, O> bind(Predicate<? super I> predicate, Supplier<? extends O> supplier) {
        return new BasicRule<I, O>(predicate, supplier);
    }
    
    public static <I, O> Rule<I, O> bind(Predicate<? super I> predicate, O value) {
        return new BasicRule<I, O>(predicate, Suppliers.ofInstance(value));
    }
    
    public static <I, O> Rule<I, O> bind(Predicate<? super I> predicate, Function<I, O> func) {
        return new FuncRule<I, O>(predicate, func);
    }

    public static <I, O> Rule<I, O> bind(Predicate<? super I> predicate, Callable<? extends O> callable) {
        return new BasicRule<I, O>(predicate, Utils.asSupplier(callable));
    }

    public static <I, O> Rule<I, O> bindMemoized(Predicate<? super I> selector, Callable<? extends O> callable) {
        return new BasicRule<I, O>(selector, Suppliers.memoize(Utils.asSupplier(callable)));
    }
}
