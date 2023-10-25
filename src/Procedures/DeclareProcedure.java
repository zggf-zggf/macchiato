package Procedures;

import Interpreter.Context;
import Interpreter.Interpretable;
import Interpreter.InterpretationException;

public class DeclareProcedure implements Interpretable {
    private final Procedure procedure;

    public DeclareProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    @Override
    public void execute(Context context) throws InterpretationException {
        context.currentBlock.declareProcedure(procedure);
    }

    @Override
    public String toString() {
        return "declare " + procedure;
    }
}
