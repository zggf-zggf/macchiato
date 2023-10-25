package Factory;

import Expressions.Expression;
import Instructions.*;
import Interpreter.Interpretable;
import Procedures.DeclareProcedure;
import Procedures.Procedure;
import Procedures.RunProcedureInstruction;

import java.util.ArrayList;

public class BlockBuilder {
    private final ArrayList<Interpretable> declarations;
    private final ArrayList<Instruction> instructions;

    public BlockBuilder(){
        declarations = new ArrayList<>();
        instructions = new ArrayList<>();
    }

    public BlockBuilder declareVariable(char c, Expression expression) {
        declarations.add(new DeclareVariable(c, expression));
        return this;
    }

    public BlockBuilder declareProcedure(String name, char[] params, NewBlockInstruction block) {
        declarations.add(new DeclareProcedure(new Procedure(name, params, block.getDeclarations(), block.getInstructions())));
        return this;
    }

    public BlockBuilder loop(char c, Expression exp, NewBlockInstruction block) {
        instructions.add(new ForLoopInstruction(c, exp, block.getInstructions()));
        return this;
    }

    public BlockBuilder print(Expression exp) {
        instructions.add(new PrintInstruction(exp));
        return this;
    }
    public BlockBuilder assign(char c, Expression exp) {
        instructions.add(new AssignValueInstruction(c, exp));
        return this;
    }

    public BlockBuilder invoke(String name, Expression[] params) {
        instructions.add(new RunProcedureInstruction(name, params));
        return this;
    }

    public BlockBuilder test(Expression exp1, ComparisonOperator op, Expression exp2, NewBlockInstruction block) {
        instructions.add(new IfStatementInstruction(exp1, exp2, op, block.getInstructions()));
        return this;
    }

    public BlockBuilder testOr(Expression exp1, ComparisonOperator op, Expression exp2, NewBlockInstruction block, NewBlockInstruction block2) {
        instructions.add(new IfStatementInstruction(exp1, exp2, op, block.getInstructions(), block2.getInstructions()));
        return this;
    }

    public BlockBuilder block(NewBlockInstruction block) {
        instructions.add(block);
        return this;
    }

    public NewBlockInstruction build() {
        Interpretable[] dec;
        Instruction[] inst;
        dec = declarations.toArray(new Interpretable[declarations.size()]);
        inst = instructions.toArray(new Instruction[instructions.size()]);
        return new NewBlockInstruction(dec, inst);
    }
}
