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

package org.rulesdsl.predicates.strings;

import org.rulesdsl.predicates.AbstractSelector;

import java.util.regex.Pattern;

/**
 * @author Roman Kashitsyn
 */
public class MatchesPatternSelector extends AbstractSelector<CharSequence> {

    private final Pattern pattern;

    public MatchesPatternSelector(Pattern pattern) {
        this.pattern = pattern;
    }


    public boolean matches(CharSequence s) {
        return pattern.matcher(s).matches();
    }
    
    @Override
    public String toString() {
        return "matchesPattern(" + pattern.toString() + ")";
    }
}
