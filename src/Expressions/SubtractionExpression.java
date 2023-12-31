package Expressions;

import Interpreter.Context;
import Interpreter.InterpretationException;

public class SubtractionExpression extends TwoArgumentExpression{
    public SubtractionExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    @Override
    public char getSymbol() {
        return '-';
    }

    @Override
    public int evaluate(Context context) throws InterpretationException {
        return exp1.evaluate(context) - exp2.evaluate(context);
    }
}
