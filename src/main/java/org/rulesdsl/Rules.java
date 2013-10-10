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
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import org.rulesdsl.rules.*;

import java.util.Arrays;
import java.util.concurrent.Callable;

/**
 * @author Roman Kashitsyn
 */
public class Rules {

    private Rules() {}

    // TODO: check why type inference does not work
    public static class OngoingRuleInitialization<I> {

        private final Predicate<? super I> predicate;

        private OngoingRuleInitialization(Predicate<? super I> predicate) {
            this.predicate = predicate;
        }

        public <O> Rule<I, O> getFrom(Supplier<? extends O> supplier) {
            return new BasicRule<I, O>(predicate, supplier);
        }

        public <O> Rule<I, O> just(O value) {
            return new BasicRule<I, O>(predicate, Suppliers.ofInstance(value));
        }

        public <O> Rule<I, O> apply(Function<? super I, ? extends O> fn) {
            return new FuncRule<I, O>(predicate, fn);
        }

        public <O> Rule<I, O> call(Callable<? extends O> callable) {
            return new BasicRule<I, O>(predicate, Utils.asSupplier(callable));
        }

        public <O> Rule<I, O> callMemoized(Callable<? extends  O> callable) {
            return new BasicRule<I, O>(predicate, Suppliers.memoize(Utils.asSupplier(callable)));
        }

        public <O> Rule<I, O> raise(Class<? extends RuntimeException> class_) {
            return new RaiseRule<I, O>(predicate, class_);
        }
    }

    public static <T> OngoingRuleInitialization<T> when(Predicate<T> predicate) {
        return new OngoingRuleInitialization<T>(predicate);
    }

    public static <I, O> RuleSet<I, O> ruleSet(Rule<? super I, ? extends O>... rules) {
        return new BasicRuleSet<I, O>(Arrays.asList(rules));
    }
}
