package Instructions;

import Factory.*;
import Interpreter.OutputCapturingInterpreter;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class InstructionsTests {
    @Test
    public void ConstantPrintTest() {
        var main = new BlockBuilder()
                .print(Constant.of(2115))
                .build();
        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "2115 ");
    }

    @Test
    public void AdditionTest() {
        var main = new BlockBuilder()
                .print(Sum.of(Constant.of(78), Constant.of(123)))
                .build();
        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "201 ");
    }

    @Test
    public void SubtractionTest() {
        var main = new BlockBuilder()
                .print(Subtraction.of(Constant.of(78), Constant.of(123)))
                .build();
        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "-45 ");
    }

    @Test
    public void MultiplicationTest() {
        var main = new BlockBuilder()
                .print(Product.of(Constant.of(78), Constant.of(123)))
                .build();
        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "9594 ");
    }
    @Test
    public void DivisionTest() {
        var main = new BlockBuilder()
                .print(Division.of(Constant.of(78), Constant.of(3)))
                .build();
        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "26 ");

        var main2 = new BlockBuilder()
                .print(Division.of(Constant.of(78), Constant.of(0)))
                .build();
        interpreter.runProgram(main2);
        assertEquals(interpreter.getOutput(), "");
    }

    @Test
    public void ModuloTest() {
        var main = new BlockBuilder()
                .print(Modulo.of(Constant.of(78), Constant.of(3)))
                .build();
        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "0 ");

        var main2 = new BlockBuilder()
                .print(Modulo.of(Constant.of(78), Constant.of(0)))
                .build();
        interpreter.runProgram(main2);
        assertEquals(interpreter.getOutput(), "");
    }

    @Test
    public void AssignTest() {
        var main = new BlockBuilder()
                .declareVariable('x', Constant.of(10))
                .declareVariable('y', Sum.of(Variable.named('x'), Constant.of(4)))
                .assign('x', Product.of(Variable.named('x'), Variable.named('y')))
                .print(Variable.named('x'))
                .print(Variable.named('y'))
                .build();
        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "140 14 ");
    }

    @Test
    public void ForIfTest() {
        var main = new BlockBuilder()
                .declareVariable('a', Constant.of(11))
                .loop('b', Variable.named('a'), new BlockBuilder()
                .testOr(
                        Variable.named('b'), ComparisonOperator.GREATER_THAN, Constant.of(6),
                        new BlockBuilder().print(Constant.of(1)).build(),
                        new BlockBuilder().print(Constant.of(0)).build()).build())
                .build();
        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "0 0 0 0 0 0 0 1 1 1 1 ");
    }
}
