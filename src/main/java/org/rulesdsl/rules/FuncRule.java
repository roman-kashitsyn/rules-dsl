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

import com.google.common.base.Function;
import com.google.common.base.Predicate;

/**
 * @author Roman Kashitsyn
 */
public class FuncRule<I, O> extends AbstractRule<I, O> {
    
    private final Function<? super I, ? extends O> func;
    
    public FuncRule(Predicate<? super I> predicate, Function<? super I, ? extends O> func) {
        super(predicate);
        this.func = func;
    }
    
    @Override protected O getValue(I input) {
        return func.apply(input);
    }
    
    @Override public String toString() {
        return "{" + getPredicate() + " -> " + func + "}";
    }

}
