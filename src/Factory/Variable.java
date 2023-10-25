package Factory;

import Expressions.VariableExpression;

public class Variable {
    public static VariableExpression named(char c) {
        return new VariableExpression(c);
    }
}
