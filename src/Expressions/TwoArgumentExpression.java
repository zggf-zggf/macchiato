package Expressions;

public abstract class TwoArgumentExpression extends Expression{

    protected final Expression exp1;
    protected final Expression exp2;

    public TwoArgumentExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    public abstract char getSymbol();

    @Override
    public String toString(){
        return exp1.toString() + " " + this.getSymbol() + " " + exp2.toString();
    }
}
