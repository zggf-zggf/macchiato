package Factory;

import Expressions.AdditionExpression;
import Expressions.Expression;

public class Sum {
    public static AdditionExpression of(Expression exp1,  Expression exp2) {
        return new AdditionExpression(exp1, exp2);
    }
}
