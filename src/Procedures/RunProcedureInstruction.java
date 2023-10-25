package Procedures;

import Expressions.Expression;
import Instructions.Instruction;
import Interpreter.Context;
import Interpreter.InterpretationException;

public class RunProcedureInstruction extends Instruction {
    private final String procedureName;
    private final Expression[] parameters;

    public RunProcedureInstruction(String procedure, Expression[] parameters) {
        this.procedureName = procedure;
        this.parameters = parameters;
    }

    @Override
    public void execute(Context context) throws InterpretationException {
        Procedure p = context.currentBlock.getProcedure(procedureName);
        context.pushBlock();
        char[] paramsVariables = p.getParamsVariables();
        for(int i = 0; i < paramsVariables.length; i++) {
            context.currentBlock.declareVariable(paramsVariables[i], parameters[i].evaluate(context));
        }
        context.getInterpreter().traverse(context, p.getDeclarations());
        context.getInterpreter().traverse(context, p.getInstructions());
        context.popBlock();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("invoke " + procedureName + "(");
        for(int i = 0; i < parameters.length - 1; i++) {
            sb.append(parameters[i]).append(", ");
        }
        if(parameters.length != 0) {
            sb.append(parameters[parameters.length - 1]);
        }
        sb.append(")");
        return sb.toString();
    }
}
