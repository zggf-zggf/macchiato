package Instructions;

import Interpreter.Context;
import Interpreter.Interpretable;
import Interpreter.InterpretationException;

public abstract class Instruction implements Interpretable {
    public abstract void execute(Context context) throws InterpretationException;
    public boolean declaresVariable(){
        return false;
    }
}
