package Interpreter;

import Procedures.Procedure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Block {
    private final Variable[] variables;
    private final Map<String, Procedure> procedures;
    private final Block parent;

    public Block(Block parent) {
        this.variables = new Variable[26];
        this.procedures = new HashMap<>();
        this.parent = parent;
    }

    public Block getParent() {
        return parent;
    }

    public Variable getVariable(char c) throws InterpretationException {
        int index = c - 'a';
        if(variables[index] == null) {
            if(parent == null) {
                throw new InterpretationException("reference to undeclared variable " + c + "\n");
            } else {
                return parent.getVariable(c);
            }
        } else {
            return variables[index];
        }
    }

    public void declareVariable(char c, int value) throws InterpretationException {
        int index = c - 'a';
        if(variables[index] != null) {
            throw new InterpretationException("Double declaration of variable " + c + " in one block\n");
        } else {
            variables[index] = new Variable(value);
        }
    }

    public String visibleVariablesToString() {
        String out = "";
        for(int i = 0; i < 26; i++) {
            char letter = (char) ('a' + i);
            Variable var = this.safeGetVariable(letter);
            if(var != null) {
                out += letter + ": " + var.value + "\n";
            }
        }
        return out;
    }
    public String visibleProceduresToString() {
        String out = "";
        Block block = this;
        Set<String> visitedProcedures = new HashSet<>();
        while(block != null) {
            for(Map.Entry<String, Procedure> entry : block.procedures.entrySet()) {
                if(visitedProcedures.contains(entry.getKey()) == false) {
                    out += entry.getValue();
                    out += "\n";
                    visitedProcedures.add(entry.getKey());
                }
            }
            block = block.getParent();
        }
        return out;
    }
    public void printVisibleVariables() {
        System.out.println(visibleVariablesToString());
    }

    private Variable safeGetVariable(char c) {
        int index = c - 'a';
        if(variables[index] == null) {
            if(parent == null) {
                return null;
            } else {
                return parent.safeGetVariable(c);
            }
        } else {
            return variables[index];
        }
    }

    public Procedure getProcedure(String name) throws InterpretationException{
        if (procedures.containsKey(name)) {
            return procedures.get(name);
        } else {
            if (parent != null) {
                return parent.getProcedure(name);
            } else {
                throw new InterpretationException("reference to undeclared procedure \"" + name + "\"\n");
            }
        }
    }

    public void declareProcedure(Procedure procedure) throws InterpretationException {
        if(procedures.containsKey(procedure.getName())) {
            throw new InterpretationException("double declaration of procedure \"" + procedure.getName() + "\"\n");
        } else {
            procedures.put(procedure.getName(), procedure);
        }
    }
}
