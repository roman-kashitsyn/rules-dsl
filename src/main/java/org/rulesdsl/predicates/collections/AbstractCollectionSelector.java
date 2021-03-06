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

package org.rulesdsl.predicates.collections;

import com.google.common.base.Joiner;
import org.rulesdsl.predicates.AbstractSelector;

/**
 * @author Roman Kashitsyn
 */
public abstract class AbstractCollectionSelector<T> extends AbstractSelector<T> {

    private final Iterable<? extends T> items;

    protected AbstractCollectionSelector(Iterable<? extends T> items) {
        this.items = items;
    }

    protected Iterable<? extends T> items() {
        return items;
    }

    protected abstract String getName();

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(getName()).append("(");
        Joiner.on(", ").appendTo(builder, items);
        return builder.append(")").toString();
    }
}
