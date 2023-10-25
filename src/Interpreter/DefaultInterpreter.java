package Interpreter;

public class DefaultInterpreter extends Interpreter{
    @Override
    protected void interpret(Context context, Interpretable instruction) throws InterpretationException {
        instruction.execute(context);
    }
}
