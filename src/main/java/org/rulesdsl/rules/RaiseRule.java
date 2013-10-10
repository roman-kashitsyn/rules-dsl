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

/**
 * @author Roman Kashitsyn
 */
public class RaiseRule<I, O> extends AbstractRule<I, O> {

    private final Class<? extends Exception> exceptionClass;

    public RaiseRule(Predicate<? super I> predicate, Class<? extends Exception> class_) {
        super(predicate);
        exceptionClass = class_;
    }

    @Override protected O getValue(final I ignored) {
        Exception o;
        try {
            o = exceptionClass.newInstance();
        } catch (Exception e) {
            o = new RuntimeException(e);
        }
        RaiseRule.<RuntimeException>castAndThrow(o);
        return null;
    }

    // Hack to avoid stupid "throws" declarations
    @SuppressWarnings("unchecked")
    private static <T extends Throwable> void castAndThrow(Throwable t) throws T {
        throw (T) t;
    }

    @Override public String toString() {
        return "{" + getPredicate() + " -> raise " + exceptionClass.getSimpleName() + "}";
    }

}
