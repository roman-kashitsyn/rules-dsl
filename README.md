RulesDSL
========

RulesDSL is a small library to express rules in Java (1.5+) with
tight Guava library integration.

Overiew
-------

*Rule* is just a partial function (so it implements the `Function`
interface). It maps its input to a value or an action.

Rules use *selectors* to decide whether they are applicable to an
input or not.  Selector is just a predicate (so it implements the
`Predicate` interface).

*RuleSet* is just a rule that combines several other rules together.

Example
-------

Here are simple examples. It's easy to understand how the library works:

```java
    // Rules in rule set will be applied one-by-one until the first
    // one succeed.
    RuleSet<String, String> rs = ruleSet(
        when(or(endsWith(".jpg"), endsWith(".jpeg"))).just("image/jpeg"),
        when(endsWith(".png")).just("image/png"),
        when(endsWith(".gif")).just("image/gif"),
        when(resultOf(trim).is(empty)).<String>raise(IllegalArgumentException.class),
        when(anything()).just("text/html")
    );

    assert(mimeTypes.apply("hello.png").equals("image/png"));
    assert(mimeTypes.apply("index").equals("text/html");

    // throws IllegalArgumentException
    String oops = rs.apply(" ");
```
