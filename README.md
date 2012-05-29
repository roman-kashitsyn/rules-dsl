RulesDSL
========

RulesDSL is a small library to express rules in Java (1.5+) with
tight Guava library integration.

Overiew
-------

*Rule* is a partial function in it's nature (so it implements the `Function`
interface). It maps some input to a value or an action.
Rules use *selectors* to deside whether they are applicable to an input or not.
Selector is a predicate in it's nature (it implements the `Predicate` interface).
*RuleSet* is just a rule that combines several other rules togather.

Example
-------

Here are simple examples. It's easy to understand how the library works:

    // Rules in rule set will be applied one-by-one until the first
    // one succeed.
    RuleSet<String, String> rs = ruleSet(
        whenTrue(or(endsWith(".jpg"), endsWith(".jpeg"))).just("image/jpeg"),
        whenTrue(endsWith(".png")).just("image/png"),
        whenTrue(endsWith(".gif")).just("image/gif"),
        whenTrue(anything()).just("text/html")
    );

    assert(mimeTypes.apply("hello.png").equals("image/png"));
