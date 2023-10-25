package Factory;

import Expressions.DivisionExpression;
import Expressions.Expression;

public class Division {
    public static DivisionExpression of(Expression exp1, Expression exp2){
        return new DivisionExpression(exp1, exp2);
    }
}
