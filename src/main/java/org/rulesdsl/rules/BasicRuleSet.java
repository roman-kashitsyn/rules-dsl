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

import com.google.common.base.Joiner;
import org.rulesdsl.Rule;
import org.rulesdsl.RuleSet;

import java.util.Collection;

/**
 * @author Roman Kashitsyn
 */
public class BasicRuleSet<I, O> implements RuleSet<I, O> {
    
    private final Iterable <? extends Rule<? super I, ? extends O>> rules;
    
    public BasicRuleSet(Collection<Rule<? super I, ? extends O>> rules) {
        this.rules = rules;
    }

    public boolean isDefinedAt(I input) {
        return ruleFor(input) != null;
    }

    public O apply(I input) {
        Rule<? super I, ? extends O> rule = ruleFor(input);
        if (rule != null) {
            return rule.apply(input);
        } else {
            throw new RuleNotApplicableException("Unable to apply " + this + " to " + input);
        }
    }

    public Rule<? super I, ? extends O> ruleFor(I input) {
        for (Rule<? super I, ? extends O> rule: rules) {
            if (rule.isDefinedAt(input)) {
                return rule;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("ruleSet{");
        Joiner.on(", ").appendTo(builder, rules);
        return builder.append("}").toString();
    }
}
