package Expressions;

import Interpreter.Context;
import Interpreter.InterpretationException;

public class VariableExpression extends Expression{

    private final char c;

    public VariableExpression(char c) {
        this.c = c;
    }

    @Override
    public int evaluate(Context context) throws InterpretationException {
        return context.currentBlock.getVariable(c).value;
    }

    @Override
    public String toString(){
        return "" + c;
    }
}
