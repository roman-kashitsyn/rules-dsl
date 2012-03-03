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

import com.google.common.base.Predicate;

/**
 * Selector interface present simple generic matcher.
 * @param <E> type to match
 * @author Roman Kashitsyn
 */
public interface Selector<E> extends Predicate<E> {

    /**
     * Returns the result of applying of the selector to given input.
     * @param e element to match
     * @return true if input matches predicate
     */
    boolean matches(E e);
}
