package org.rulesdsl;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import org.junit.Test;

import static com.google.common.base.Predicates.or;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.rulesdsl.Rules.ruleSet;
import static org.rulesdsl.Rules.when;
import static org.rulesdsl.Selectors.*;
import static org.rulesdsl.StringSelectors.endsWith;
import static org.rulesdsl.StringSelectors.empty;

/**
 * Tests for {@link Rules}.
 * @author Roman Kashitsyn
 */
public class RulesTest {

    private static final Function<String, String> trim = new Function<String, String>() {
        public String apply(String string) {
            return string == null ? "" : string.trim();
        }
    };

    private static final Predicate<Integer> even = new Predicate<Integer>() {
        public boolean apply(Integer integer) {
            return integer == null || (integer & 1) == 0;
        }
    };

    @Test
    public void testOneRule() {
        Rule<Integer, Integer> evenToZero = when(even).just(0);
        assertEquals(Integer.valueOf(0), evenToZero.apply(2));
        assertEquals(Integer.valueOf(0), evenToZero.apply(4));
        assertEquals(Integer.valueOf(0), evenToZero.apply(null));
    }

    @Test
    public void testHeterogeneousRuleSet() {
        Rule<String, String> nullToEmpty = ruleSet(
                when(isNull()).just(""),
                when(anything(String.class)).apply(trim)
        );

        assertEquals("", nullToEmpty.apply(null));
        assertEquals("hello", nullToEmpty.apply("   hello   "));
    }

    @Test
    public void testRuleSet() {
        RuleSet<String, String> rs = ruleSet(
                when(or(endsWith(".jpg"), endsWith(".jpeg"))).just("image/jpeg"),
                when(endsWith(".png")).just("image/png"),
                when(endsWith(".gif")).just("image/gif"),
                when(resultOf(trim).is(empty)).<String>raise(IllegalArgumentException.class),
                when(anything()).just("text/html")
        );

        assertEquals("image/png", rs.apply("test.png"));
        assertEquals("image/gif", rs.apply("test.gif"));
        assertEquals("image/jpeg", rs.apply("test.jpg"));
        assertEquals("image/jpeg", rs.apply("test.jpeg"));
        assertEquals("text/html", rs.apply("no-extension"));
        try {
            rs.apply("  ");
            assertTrue(false);
        } catch (IllegalArgumentException e) { }
    }
}
