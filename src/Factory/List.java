package Factory;

import Expressions.Expression;

public class List {
    public static char[] of(char ... chars) {
        return chars;
    }

    public static Expression[] of(Expression ... expressions) {
        return expressions;
    }
}
