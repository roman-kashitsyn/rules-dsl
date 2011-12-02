package org.jmatch.selectors;

import com.google.common.base.Joiner;
import org.jmatch.Selector;

/**
 * @author Roman Kashitsyn
 */
public class AnyOfSelector<E> extends AbstractSelector<E> {
    
    private final Iterable<Selector<? super E>> selectors;

    public AnyOfSelector(Iterable<Selector<? super E>> selectors) {
        this.selectors = selectors;
    }
    
    public boolean matches(E e) {
        boolean matches = false;
        for (Selector<? super E> selector : selectors) {
            if (selector.matches(e)) {
                matches = true;
                break;
            }
        }
        return matches;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("anyOf[");
        Joiner.on(", ").appendTo(builder, selectors);
        return builder.append("]").toString();
    }
}
