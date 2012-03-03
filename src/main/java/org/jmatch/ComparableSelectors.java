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

import org.jmatch.predicates.comparables.*;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * @author Roman Kashitsyn
 */
public class ComparableSelectors {
    
    private ComparableSelectors() {}
    
    public static <T extends Comparable<? super T>> Selector<T> greaterThan(final T value) {
        checkNotNull(value);
        return new GreaterThanSelector<T>(value);
    }
    
    public static <T extends Comparable<? super T>> Selector<T> greaterOrEquals(final T value) {
        checkNotNull(value);
        return new GreaterOrEqualsSelector<T>(value);
    }
    
    public static <T extends Comparable<? super T>> Selector<T> lesserThan(final T value) {
        checkNotNull(value);
        return new LesserThanSelector<T>(value);
    }

    public static <T extends Comparable<? super T>> Selector<T> lesserOrEquals(final T value) {
        checkNotNull(value);
        return new LesserOrEqualsSelector<T>(value);
    }

    public static <T extends Comparable<? super T>> Selector<T> between(T lowerBound, T upperBound) {
        checkNotNull(lowerBound);
        checkNotNull(upperBound);
        return new BetweenSelector<T>(lowerBound, upperBound);
    }
}
