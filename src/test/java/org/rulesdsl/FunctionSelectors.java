package org.rulesdsl;

import com.google.common.base.Function;
import org.junit.Test;

import javax.annotation.Nullable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.rulesdsl.Selectors.equalTo;
import static org.rulesdsl.Selectors.when;

/**
 * Tests for function selectors from {@link Selectors}.
 * @author Roman Kashitsyn
 */
public class FunctionSelectors {

    private static final Function<Integer, Integer> mod10 = new Function<Integer, Integer>() {
        public Integer apply(@Nullable Integer integer) {
            return integer == null ? 0 : integer % 10;
        }
    };

    @Test
    public void checkSimpleFunctionSelector() {
        Selector<Integer> have3InReminder = when(mod10).output(equalTo(3));
        assertTrue(have3InReminder.matches(3));
        assertTrue(have3InReminder.matches(13));
        assertFalse(have3InReminder.matches(5));
    }
}
