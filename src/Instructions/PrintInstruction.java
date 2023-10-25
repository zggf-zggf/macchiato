package Instructions;

import Expressions.Expression;
import Interpreter.Context;
import Interpreter.InterpretationException;

public class PrintInstruction extends Instruction{
    private final Expression exp;

    public PrintInstruction(Expression exp) {
        this.exp = exp;
    }

    @Override
    public void execute(Context context) throws     InterpretationException {
        System.out.println(exp.evaluate(context));
    }

    @Override
    public String toString(){
        return "print " + exp.toString();
    }

    public Expression getExpression(){
        return exp;
    }
}
