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

import org.jmatch.predicates.strings.ContainsSubstringSelector;
import org.jmatch.predicates.strings.EndsWithSelector;
import org.jmatch.predicates.strings.MatchesPatternSelector;
import org.jmatch.predicates.strings.StartsWithSelector;

import java.util.regex.Pattern;

/**
 * @author Roman Kashitsyn
 */
public class StringSelectors {
    
    private StringSelectors() {}
    
    public static Selector<String> startsWith(String prefix) {
        return new StartsWithSelector(prefix);
    }
    
    public static Selector<String> endsWith(String suffix) {
        return new EndsWithSelector(suffix);
    }
    
    public static Selector<String> contains(String substring) {
        return new ContainsSubstringSelector(substring);
    }
    
    public static Selector<CharSequence> matchesPattern(Pattern pattern) {
        return new MatchesPatternSelector(pattern);
    }
    
    public static Selector<CharSequence> matchesPattern(String regex) {
        Pattern pattern = Pattern.compile(regex);
        return new MatchesPatternSelector(pattern);
    }
}
