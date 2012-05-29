package org.rulesdsl;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.rulesdsl.Selectors.anyInstanceOf;

/**
 * Tests for {@link Selectors}.
 * @author Roman Kashitsyn
 */
public class ReflectiveSelectorsTest {

    @Test
    public void testInstanceOfSelector() {
        Selector<Integer> isInteger = anyInstanceOf(Integer.class);
        assertTrue(isInteger.apply(5));
        assertFalse(isInteger.apply(null));
    }
}
