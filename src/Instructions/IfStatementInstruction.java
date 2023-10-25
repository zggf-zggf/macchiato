package Instructions;

import Expressions.Expression;
import Interpreter.Context;
import Interpreter.InterpretationException;
import Interpreter.Interpreter;

public class IfStatementInstruction extends Instruction{
    private final Expression exp1, exp2;
    private final ComparisonOperator operator;
    private final Instruction[] mainInstructions;
    private final Instruction[] elseInstructions;

    public IfStatementInstruction(Expression exp1, Expression exp2, ComparisonOperator operator, Instruction[] instructions) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operator = operator;
        this.mainInstructions = instructions;
        elseInstructions = new Instruction[0];
    }

    public IfStatementInstruction(Expression exp1, Expression exp2, ComparisonOperator operator, Instruction[] instructions, Instruction[] elseInstructions) {
        this.exp1 = exp1;
        this.exp2 = exp2;
        this.operator = operator;
        this.mainInstructions = instructions;
        this.elseInstructions = elseInstructions;
    }

    @Override
    public void execute(Context context) throws InterpretationException {
        int A = exp1.evaluate(context);
        int B = exp2.evaluate(context);
        Interpreter interpreter = context.getInterpreter();
        if(operator.compare(A, B)) {
            interpreter.traverse(context, mainInstructions);
        } else {
            interpreter.traverse(context, elseInstructions);
        }
    }

    @Override
    public String toString(){
        return "if " + exp1.toString() + " " + operator + " " + exp2.toString();
    }
}
