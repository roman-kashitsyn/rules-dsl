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

package org.rulesdsl.rules;

import com.google.common.base.Predicate;
import com.google.common.base.Supplier;

/**
 * @author Roman Kashitsyn
 */
public class BasicRule<I, O> extends AbstractRule<I, O> {
    
    private final Supplier<? extends O> supplier;

    public BasicRule(Predicate<? super I> predicate, Supplier<? extends O> supplier) {
        super(predicate);
        this.supplier = supplier;
    }

    protected O getValue(I input) {
        return supplier.get();
    }
}
