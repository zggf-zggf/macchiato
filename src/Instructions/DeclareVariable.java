package Instructions;

import Expressions.Expression;
import Interpreter.Context;
import Interpreter.Interpretable;
import Interpreter.InterpretationException;

public class DeclareVariable implements Interpretable {
    private final char c;
    private final Expression exp;

    public DeclareVariable(char c, Expression exp) {
        this.c = c;
        this.exp = exp;
    }

    @Override
    public void execute(Context context) throws InterpretationException {
        context.currentBlock.declareVariable(c, exp.evaluate(context));
    }

    @Override
    public String toString(){
        return "var " + c + " = " + exp.toString();
    }
}
