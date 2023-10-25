package Expressions;

import Interpreter.Context;
import Interpreter.InterpretationException;

public abstract class Expression {
    public abstract int evaluate(Context context) throws InterpretationException;
}
