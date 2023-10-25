package Interpreter;

import Instructions.NewBlockInstruction;

public abstract class Interpreter {
    public void runProgram(NewBlockInstruction mainBlock) {
        Context context = new Context(this);
        try {
            interpret(context, mainBlock);
            System.out.println("Program ended successfully");
        } catch (InterpretationException e) {
            System.out.println("ERROR!");
            System.out.println(e.getMessage());
            System.out.println("variable values:");
            context.currentBlock.printVisibleVariables();
        }
    }

    public void traverse(Context context, Interpretable[] instructions) throws InterpretationException {
        for(Interpretable i : instructions) {
            try {
                interpret(context, i);
            } catch (InterpretationException e) {
                if(e.tagged) {
                    throw e;
                } else {
                    throw new InterpretationException(e.getMessage()+
                            "\nCaused by instruction: \n" + i, true);
                }
            }
        }
    }

    protected abstract void interpret(Context context, Interpretable instruction) throws InterpretationException;
}
