package Interpreter;

import Instructions.NewBlockInstruction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Debugger extends Interpreter{
    private int stepsLeft;
    private boolean exited;

    @Override
    public void runProgram(NewBlockInstruction mainBlock) {
        stepsLeft = 0;
        exited = false;
        super.runProgram(mainBlock);
    }
    @Override
    protected void interpret(Context context, Interpretable instruction) throws InterpretationException {
        if(exited) return;
        if(stepsLeft == 0)
            System.out.println(instruction);
        while(stepsLeft == 0 && !exited) {
            getUserInput(context);
        }
        if(exited) return;
        if(stepsLeft > 0)
            stepsLeft--;
        instruction.execute(context);
    }

    void getUserInput(Context context) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);
        switch (c) {
            case 'c' -> stepsLeft = -1;
            case 's' -> {
                try {
                    stepsLeft = scanner.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("wrong command!");
                    stepsLeft = 0;
                }
            }
            case 'd' -> {
                int depth = scanner.nextInt();
                Block block = context.currentBlock;
                for(int i = 0; i < depth; i++) {
                    if(block == null) break;
                    block = block.getParent();
                }
                if(block == null)
                    System.out.println("Nesting is not that deep");
                else block.printVisibleVariables();
            }
            case 'e' -> exited = true;
            case 'm' -> {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(scanner.next()));
                    bw.write(context.currentBlock.visibleProceduresToString() + context.currentBlock.visibleVariablesToString());
                    bw.close();
                    System.out.println("Memory dumped to file.");
                } catch (IOException e) {
                    System.out.println("IOException when writing to file!");
                }
            }
            default -> System.out.println("wrong command!");
        }
    }

}
