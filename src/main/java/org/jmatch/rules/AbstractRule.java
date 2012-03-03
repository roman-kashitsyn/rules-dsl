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

package org.jmatch.rules;

import com.google.common.base.Predicate;
import org.jmatch.Rule;
import org.jmatch.Selector;

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public abstract class AbstractRule<I, O> implements Rule<I, O> {
    
    private final Predicate<? super I> predicate;
    
    public AbstractRule(Predicate<? super I> predicate) {
        this.predicate = predicate;
    }
    
    public O apply(I x) {
        if( !isDefinedAt(x) ) {
            throw new RuleNotApplicableException("Input " + x + " does not match " + predicate);
        }
        return getValue(x);
    }
    
    public boolean isDefinedAt(I x) {
        return predicate.apply(x);
    }
    
    protected abstract O getValue(I input);
    
    protected Predicate<? super I> getPredicate() {
        return predicate;
    }
}
