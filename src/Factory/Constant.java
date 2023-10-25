package Factory;

import Expressions.LiteralExpression;

public class Constant {
    public static LiteralExpression of(int x) {
        return new LiteralExpression(x);
    }
}
