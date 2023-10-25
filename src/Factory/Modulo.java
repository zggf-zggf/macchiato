package Factory;

import Expressions.Expression;
import Expressions.ModuloExpression;

public class Modulo {
    public static ModuloExpression of(Expression exp1, Expression exp2){
        return new ModuloExpression(exp1, exp2);
    }
}
