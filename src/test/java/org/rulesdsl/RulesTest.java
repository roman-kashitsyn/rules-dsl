package org.rulesdsl;

import com.google.common.base.Predicate;
import org.junit.Test;

import javax.annotation.Nullable;

import static com.google.common.base.Predicates.not;
import static com.google.common.base.Predicates.or;
import static org.junit.Assert.assertEquals;
import static org.rulesdsl.Rules.ruleSet;
import static org.rulesdsl.Rules.whenTrue;
import static org.rulesdsl.Selectors.anything;
import static org.rulesdsl.StringSelectors.endsWith;

/**
 * Tests for {@link Rules}.
 * @author Roman Kashitsyn
 */
public class RulesTest {

    private static final Predicate<Integer> even = new Predicate<Integer>() {
        public boolean apply(Integer integer) {
            return integer == null || (integer & 1) == 0;
        }
    };

    @Test
    public void testOneRule() {
        Rule<? super Integer, Integer> evenToZero = whenTrue(even).just(0);
        assertEquals(Integer.valueOf(0), evenToZero.apply(2));
        assertEquals(Integer.valueOf(0), evenToZero.apply(4));
        assertEquals(Integer.valueOf(0), evenToZero.apply(null));
    }

    @Test
    public void testRuleSet() {
        RuleSet<String, String> rs = ruleSet(
                whenTrue(or(endsWith(".jpg"), endsWith(".jpeg"))).just("image/jpeg"),
                whenTrue(endsWith(".png")).just("image/png"),
                whenTrue(endsWith(".gif")).just("image/gif"),
                whenTrue(anything()).just("text/html")
        );

        assertEquals("image/png", rs.apply("test.png"));
        assertEquals("image/gif", rs.apply("test.gif"));
        assertEquals("image/jpeg", rs.apply("test.jpg"));
        assertEquals("image/jpeg", rs.apply("test.jpeg"));
        assertEquals("text/html", rs.apply("no-extension"));
    }
}
