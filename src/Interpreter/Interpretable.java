package Interpreter;

public interface Interpretable {
    void execute(Context context) throws InterpretationException;
}
