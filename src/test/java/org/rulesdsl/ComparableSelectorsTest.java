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

package org.rulesdsl;

import org.junit.Test;

import static org.rulesdsl.ComparableSelectors.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for {@link ComparableSelectors}.
 * @author Roman Kashitsyn
 */
public class ComparableSelectorsTest {

    @Test
    public void testGreaterThan() {
        Selector<Integer> greaterThan10 = greaterThan(10);
        assertTrue(greaterThan10.matches(11));
        assertFalse(greaterThan10.matches(10));
        assertFalse(greaterThan10.matches(-1));
        assertTrue(greaterThan10.matches(Integer.MAX_VALUE));
        assertFalse(greaterThan10.matches(Integer.MIN_VALUE));
        assertFalse(greaterThan10.matches(null));
    }

    @Test
    public void testGreaterOrEquals() {
        Selector<Integer> greaterOrEquals10 = greaterOrEquals(10);
        assertTrue(greaterOrEquals10.matches(11));
        assertTrue(greaterOrEquals10.matches(10));
        assertFalse(greaterOrEquals10.matches(-1));
        assertTrue(greaterOrEquals10.matches(Integer.MAX_VALUE));
        assertFalse(greaterOrEquals10.matches(Integer.MIN_VALUE));
        assertFalse(greaterOrEquals10.matches(null));
    }

    @Test
    public void testLesserThan() {
        Selector<Integer> lesserThan100 = lesserThan(100);
        assertTrue(lesserThan100.matches(0));
        assertTrue(lesserThan100.matches(99));
        assertFalse(lesserThan100.matches(100));
        assertFalse(lesserThan100.matches(101));
        assertTrue(lesserThan100.matches(Integer.MIN_VALUE));
        assertFalse(lesserThan100.matches(Integer.MAX_VALUE));
        assertFalse(lesserThan100.matches(null));
    }

    @Test
    public void testLesserOrEquals() {
        Selector<Integer> lesserOrEquals100 = lesserOrEquals(100);
        assertTrue(lesserOrEquals100.matches(0));
        assertTrue(lesserOrEquals100.matches(99));
        assertTrue(lesserOrEquals100.matches(100));
        assertFalse(lesserOrEquals100.matches(101));
        assertTrue(lesserOrEquals100.matches(Integer.MIN_VALUE));
        assertFalse(lesserOrEquals100.matches(Integer.MAX_VALUE));
        assertFalse(lesserOrEquals100.matches(null));
    }

    @Test
    public void testInRange() {
        Selector<Integer> between_5_and_10 = between(5, 10);
        assertTrue(between_5_and_10.matches(6));
        assertTrue(between_5_and_10.matches(5));
        assertTrue(between_5_and_10.matches(10));
        assertFalse(between_5_and_10.matches(4));
        assertFalse(between_5_and_10.matches(11));
        assertFalse(between_5_and_10.matches(Integer.MIN_VALUE));
        assertFalse(between_5_and_10.matches(Integer.MAX_VALUE));
        assertFalse(between_5_and_10.matches(null));
    }
}
