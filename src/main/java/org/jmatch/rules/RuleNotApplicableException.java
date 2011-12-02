package org.jmatch.rules;

/**
 * @author Roman Kashitsyn
 * @since 1.0
 */
public class RuleNotApplicableException extends RuntimeException {
    public RuleNotApplicableException() {
        super();
    }
    
    public RuleNotApplicableException(String message) {
        super(message);
    }
}
