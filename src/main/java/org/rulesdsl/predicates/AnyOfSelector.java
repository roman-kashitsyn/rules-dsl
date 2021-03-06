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

import com.google.common.base.Joiner;
import com.google.common.base.Predicate;

/**
 * @author Roman Kashitsyn
 */
public class AnyOfSelector<E> extends AbstractPredicateCollectionSelector<E> {
    
    public AnyOfSelector(Iterable<? extends Predicate<? super E>> predicates) {
        super(predicates);
    }
    
    public boolean matches(E e) {
        for (Predicate<? super E> selector : predicates()) {
            if (selector.apply(e)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("anyOf[");
        Joiner.on(", ").appendTo(builder, predicates());
        return builder.append("]").toString();
    }
}
