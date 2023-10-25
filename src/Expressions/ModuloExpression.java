package Expressions;

import Interpreter.Context;
import Interpreter.InterpretationException;

public class ModuloExpression extends  TwoArgumentExpression{
    public ModuloExpression(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    @Override
    public char getSymbol() {
        return '%';
    }

    @Override
    public int evaluate(Context context) throws InterpretationException {
        int dividend = exp2.evaluate(context);
        if(dividend == 0) {
            throw new InterpretationException("Division by 0");
        }
        return exp1.evaluate(context) % dividend;
    }
}
