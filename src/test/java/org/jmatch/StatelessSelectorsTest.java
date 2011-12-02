package org.jmatch;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.jmatch.Selectors.*;

/**
 * @author Roman Kashitsyn
 */
public class StatelessSelectorsTest {
    
    @Test public void testNullSelector() {
        assertTrue(isNull().matches(null));
        assertFalse(isNull().matches(new Object()));
    }
}
