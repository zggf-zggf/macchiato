package Factory;

import Expressions.Expression;
import Expressions.MultiplicationExpression;

public class Product {
    public static MultiplicationExpression of(Expression exp1, Expression exp2){
        return new MultiplicationExpression(exp1, exp2);
    }
}
