package Interpreter;

public class Context {
    public Block currentBlock;
    private final Interpreter interpreter;

    public Context(Interpreter interpreter) {
        this.interpreter = interpreter;
        this.currentBlock = null;
    }

    public Interpreter getInterpreter() {
        return interpreter;
    }

    public void pushBlock() {
        currentBlock = new Block(currentBlock);
    }
    public void popBlock() {
        if(currentBlock != null) {
            currentBlock = currentBlock.getParent();
        }
    }
}
