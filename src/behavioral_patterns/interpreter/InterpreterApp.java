package behavioral_patterns.interpreter;

public class InterpreterApp {
    public static void main(String[] args) {
        Context context = new Context();
        Expression exp = context.evaluable("1-2+3");
        System.out.println(exp.interpret());
    }
}

class Context {

    public Expression evaluable (String str) {
        int pos = str.length()-1;

        while (pos > 0) {

            if(Character.isDigit(str.charAt(pos))) {
                pos--;
            } else {
                Expression left = evaluable(str.substring(0, pos)); //1-2 ("+" not included)
                Expression right = new TerminalExpression(Integer.parseInt(str.substring(pos+1)));
                char operator = str.charAt(pos);
                switch (operator) {
                    case '-': return new MinusExpression(left, right);
                    case '+': return new PlusExpression(left, right);
                }
            }
        }
        int result = Integer.parseInt(str);
        return new TerminalExpression(result);
    }
}

interface Expression {
    int interpret();
}

class TerminalExpression implements Expression {
    int number;

    public TerminalExpression(int number) {
        this.number = number;
    }

    @Override
    public int interpret() {
        return number;
    }
}

class MinusExpression implements Expression{
    Expression left;
    Expression right;

    public MinusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() - right.interpret();
    }
}

class PlusExpression implements Expression{
    Expression left;
    Expression right;

    public PlusExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int interpret() {
        return left.interpret() + right.interpret();
    }
}
