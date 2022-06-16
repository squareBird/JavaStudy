package Calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operater {
    MULTIPLY("*", (num1, num2) -> num1*num2),
    DIVIDE("/",(num1, num2) -> num1/num2),
    PLUS("+",(num1, num2) -> num1+num2),
    MINUS("-",(num1, num2) -> num1-num2);

    private String symbol;
    private BiFunction<Integer, Integer, Integer> expression;

    Operater(String symbol, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.expression = expression;
    }

    public static Operater of(String symbol) {
        return Arrays.stream(Operater.values()).filter(operater -> operater.symbol.equals(symbol)).findAny().orElseThrow(()->new RuntimeException());
    }

    public int caculate(int num1, int num2) {
        return expression.apply(num1,num2);
    }
}
