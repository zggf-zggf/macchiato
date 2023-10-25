package Procedures;

import Factory.*;
import Factory.List;
import Factory.Subtraction;
import Factory.Variable;
import Interpreter.*;
import org.junit.Test;

import static Instructions.ComparisonOperator.LESS_THAN_OR_EQUAL;
import static junit.framework.TestCase.assertEquals;

public class ProcedureTests {
    @Test
    public void sumTest(){
        //begin block
        //  void sum(l, s) {
        //      l = l - 1
        //      if l <= 0 then
        //          print s
        //      else
        //          s = s + l
        //          sum(l, s)
        //  }
        //  sum(10, 0)
        //end block
        var main = new BlockBuilder()
                .declareProcedure(
                        "sum", List.of('l', 's'),
                        new BlockBuilder()
                                .assign('l', Subtraction.of(Variable.named('l'), Constant.of(1)))
                                .testOr(Variable.named('l'), LESS_THAN_OR_EQUAL, Constant.of(0), new BlockBuilder()
                                        .print(Variable.named('s')).build(), new BlockBuilder()
                                        .assign('s', Sum.of(Variable.named('s'), Variable.named('l')))
                                        .invoke("sum", List.of(Variable.named('l'), Variable.named('s'))).build())
                                .build())
                .invoke("sum", List.of(Constant.of(10), Constant.of(0)))
                .build();

        OutputCapturingInterpreter interpreter = new OutputCapturingInterpreter();
        interpreter.runProgram(main);
        assertEquals(interpreter.getOutput(), "45 ");
    }
}
