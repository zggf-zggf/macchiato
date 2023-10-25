package Procedures;

import Interpreter.Interpretable;

import java.util.Arrays;

public class Procedure {
    private final String name;
    private final char[] paramsVariables;
    private final Interpretable[] declarations;
    private final Interpretable[] instructions;

    public Procedure(String name, char[] parameters, Interpretable[] declarations, Interpretable[] instructions) {
        this.name = name;
        this.paramsVariables = parameters;
        this.declarations = declarations;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public char[] getParamsVariables() {
        return paramsVariables;
    }

    public Interpretable[] getDeclarations() {
        return declarations;
    }

    public Interpretable[] getInstructions() {
        return instructions;
    }

    @Override
    public String toString() {
        return "function " + name + Arrays.toString(paramsVariables);
    }
}
