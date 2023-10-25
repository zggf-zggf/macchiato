package Instructions;

import Expressions.Expression;
import Interpreter.Context;
import Interpreter.InterpretationException;

public class AssignValueInstruction extends Instruction{
    private final char c;
    private final Expression exp;

    public AssignValueInstruction(char c, Expression exp) {
        this.c = c;
        this.exp = exp;
    }

    @Override
    public void execute(Context context) throws InterpretationException {
        context.currentBlock.getVariable(c).value = exp.evaluate(context);
    }

    @Override
    public String toString(){
        return c + " = " + exp.toString();
    }
}
