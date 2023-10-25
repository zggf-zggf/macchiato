package Expressions;

import Interpreter.Context;
import Interpreter.InterpretationException;

public class LiteralExpression extends Expression{

    private final int value;

    public LiteralExpression(int value) {
        this.value = value;
    }

    @Override
    public int evaluate(Context context) throws InterpretationException {
        return value;
    }

    @Override
    public String toString(){
        return Integer.toString(value);
    }
}
