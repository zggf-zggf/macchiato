package Interpreter;

import Instructions.NewBlockInstruction;
import Instructions.PrintInstruction;

public class OutputCapturingInterpreter extends Interpreter{
    private StringBuilder stringBuilder;

    @Override
    public void runProgram(NewBlockInstruction mainBlock) {
        stringBuilder = new StringBuilder();
        super.runProgram(mainBlock);
    }
    @Override
    protected void interpret(Context context, Interpretable instruction) throws InterpretationException {
        if(instruction instanceof PrintInstruction) {
            stringBuilder.append(((PrintInstruction) instruction).getExpression().evaluate(context));
            stringBuilder.append(" ");
        } else {
            instruction.execute(context);
        }
    }

    public String getOutput() {
        return stringBuilder.toString();
    }
}
