package Interpreter;

public class InterpretationException extends Exception{
    public boolean tagged;
    public InterpretationException(String message){
        super(message);
        tagged = false;
    }
    InterpretationException(String message, boolean tagged){
        super(message);
        this.tagged = tagged;
    }
}
