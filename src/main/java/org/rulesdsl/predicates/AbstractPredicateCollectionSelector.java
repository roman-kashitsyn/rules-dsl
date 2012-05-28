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

package org.rulesdsl.predicates;

import com.google.common.base.Predicate;

/**
 * @author Roman Kashitsyn
 */
public abstract class AbstractPredicateCollectionSelector<T> extends AbstractSelector<T> {

    private final Iterable<? extends Predicate<? super T>> predicates;

    protected AbstractPredicateCollectionSelector(Iterable<? extends Predicate<? super T>> predicates) {
        this.predicates = predicates;
    }

    protected Iterable<? extends Predicate<? super T>> predicates() {
        return predicates;
    }
}
