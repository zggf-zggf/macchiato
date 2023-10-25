package Factory;

import Expressions.Expression;
import Expressions.SubtractionExpression;

public class Subtraction {
    public static SubtractionExpression of(Expression exp1, Expression exp2) {
        return new SubtractionExpression(exp1, exp2);
    }
}
