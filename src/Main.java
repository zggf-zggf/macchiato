import Expressions.*;
import Factory.BlockBuilder;
import Factory.*;
import Factory.Variable;
import Interpreter.*;

public class Main {
    public static void main(String[] args) {
        /*
        Stary przykład
        var main = new BlockBuilder()
                .declareVariable('x', Constant.of(57))
                .declareVariable('y', Constant.of(15))
                .declareProcedure(
                        "out", List.of('a'),
                        new BlockBuilder().print(Variable.named('a')).build()
                )
                .assign('x', Subtraction.of(Variable.named('x'), Variable.named('y')))
                .invoke("out", List.of(Variable.named('x')))
                .invoke("out", List.of(Constant.of(125)))
                .build();

        //new DefaultInterpreter().runProgram(main);
        new Debugger().runProgram(main);
         */
        var program = new BlockBuilder()
                .declareVariable('x', Constant.of(101))
                .declareVariable('y', Constant.of(1))
                .declareProcedure("out", List.of('a'), new BlockBuilder()
                        .print(Sum.of(Variable.named('a'), Variable.named('x')))
                        .build()
                )
                .assign('x', Subtraction.of(Variable.named('x'), Variable.named('y')))
                .invoke("out", List.of(Variable.named('x')))
                .invoke("out", List.of(Constant.of(100)))
                .block(new BlockBuilder()
                        .declareVariable('x', Constant.of(10))
                        .invoke("out", List.of(Constant.of(100)))
                        .build()
                )
                .build();

        //new DefaultInterpreter().runProgram(program);
        new Debugger().runProgram(program);
    }
}