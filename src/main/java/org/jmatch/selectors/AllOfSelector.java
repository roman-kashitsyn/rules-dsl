package org.jmatch.selectors;

import com.google.common.base.Joiner;
import org.jmatch.Selector;

/**
 * @author Roman Kashitsyn
 */
public class AllOfSelector<E> extends AbstractSelector<E> {
    
    private final Iterable<Selector<? super E>> selectors;
    
    public AllOfSelector(Iterable<Selector<? super E>> selectors) {
        this.selectors = selectors;
    }
    
    public boolean matches(E e) {
        boolean matched = true;
        for (Selector<? super E> selector : selectors) {
            if (!selector.matches(e)) {
                matched = false;
                break;
            }
        }
        return matched;
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("allOf[");
        Joiner.on(", ").appendTo(builder, selectors);
        return builder.append("]").toString();
    }
}
