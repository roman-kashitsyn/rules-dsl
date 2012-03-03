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

import static org.jmatch.Selectors.*;
import static org.jmatch.ComparableSelectors.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * @author Roman Kashitsyn
 */
public class LogicalSelectorsTest {
    
    @Test
    public void testNotSelector() {
        assertTrue(
                not(greaterOrEquals(5)).matches(4)
        );
        assertFalse(
                not(lesserOrEquals(4)).matches(4)
        );
    }
    
    @Test
    public void testAllOfSelector() {
        assertTrue(
                allOf(greaterThan(10), lesserThan(15)).matches(13)
        );
        assertTrue(
                allOf(greaterOrEquals(10), lesserOrEquals(10)).matches(10)
        );
        assertFalse(
                allOf(greaterOrEquals(10), lesserOrEquals(5)).matches(10)
        );
    }

    @Test
    public void testAnyOfSelector() {
        assertTrue(
                anyOf(greaterThan(10), lesserOrEquals(5)).matches(12)
        );
        assertTrue(
                anyOf(greaterThan(10), lesserOrEquals(5)).matches(3)
        );
        assertFalse(
                anyOf(greaterThan(6), lesserOrEquals(4)).matches(5)
        );
    }
    
    @Test
    public void testNonOfSelector() {
        assertTrue(
                nonOf(greaterThan(5), lesserOrEquals(4)).matches(5)
        );
        assertFalse(
                nonOf(greaterThan(4), lesserOrEquals(4)).matches(4)
        );
    }
}
