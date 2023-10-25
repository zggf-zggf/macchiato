package Instructions;

import Interpreter.Context;
import Interpreter.InterpretationException;
import Interpreter.Interpreter;
import Interpreter.Interpretable;

public class NewBlockInstruction extends Instruction{
    private final Interpretable[] declarations;
    private final Instruction[] instructions;

    public NewBlockInstruction(Interpretable[] declarations, Instruction[] instructions) {
        this.declarations = declarations;
        this.instructions = instructions;
    }

    @Override
    public void execute(Context context) throws InterpretationException {
        context.pushBlock();
        Interpreter interpreter = context.getInterpreter();
        interpreter.traverse(context, declarations);

        for(Instruction i : instructions) {
            if(i.declaresVariable()) throw new InterpretationException("Cannot declare variables in block's instruction sequence");
        }
        interpreter.traverse(context, instructions);
        context.popBlock();
    }

    @Override
    public String toString(){
        return "newBlock";
    }

    public Instruction[] getInstructions() {
        return instructions;
    }

    public Interpretable[] getDeclarations() {
        return declarations;
    }
}
