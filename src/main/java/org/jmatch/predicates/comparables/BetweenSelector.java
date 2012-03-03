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

package org.jmatch.predicates.comparables;

import org.jmatch.predicates.AbstractSelector;

/**
 * @author Roman Kashitsyn
 */
public class BetweenSelector<T extends Comparable<? super T>> extends AbstractSelector<T> {
    
    private final T lowerBound;
    private final T upperBound;
    
    public BetweenSelector(T lowerBound, T upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }
    
    public boolean matches(T t) {
        return t != null && lowerBound.compareTo(t) <= 0 && upperBound.compareTo(t) >= 0;
    }
    
    @Override
    public String toString() {
        return "between(" + lowerBound + ", " + upperBound + ")";
    }
}
