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

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public class EqualToSelector extends AbstractSelector<Object> {
    private final Object matchAgainst;
    
    public EqualToSelector(Object matchAgainst) {
        this.matchAgainst = matchAgainst;
    } 
    
    public boolean matches(Object o) {
        return matchAgainst.equals(o);
    }

    @Override public String toString() {
        return "equalTo(" + matchAgainst + ")";
    }
}
