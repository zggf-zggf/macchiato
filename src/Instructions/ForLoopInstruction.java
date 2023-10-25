package Instructions;

import Expressions.Expression;
import Interpreter.Context;
import Interpreter.InterpretationException;

public class ForLoopInstruction extends Instruction{
    private final char c;
    private final Expression exp;
    private final Instruction[] instructions;

    public ForLoopInstruction(char c, Expression exp, Instruction[] instructions) {
        this.c = c;
        this.exp = exp;
        this.instructions = instructions;
    }

    @Override
    public void execute(Context context) throws InterpretationException {
        context.pushBlock();
        context.currentBlock.declareVariable(c, 0);
        int limit = exp.evaluate(context);
        for(int i = 0; i < limit; i++) {
            context.currentBlock.getVariable(c).value = i;
            context.getInterpreter().traverse(context, instructions);
        }
        context.popBlock();
    }

    @Override
    public String toString(){
        return "for " + c + " " + exp.toString() + ": ";
    }
}
