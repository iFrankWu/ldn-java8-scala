package lv.ldn.java8;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.LongBinaryOperator;
import java.util.function.Supplier;

import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public abstract class Lambda {

    public void main() {

        supplier(() -> 42);

        function((Integer n) -> n + 2);

        biFunction((String s1, String s2) -> s1 + s2);

        longBinaryOperator((x, y) -> x + y);

        longBinaryOperator((x, y) -> {
            long xx = x * x;
            long yy = y * y;
            return round(sqrt(xx + yy));
        });

    }

    abstract <T> void supplier(Supplier<T> supplier);

    abstract <T, U> void function(Function<T, U> function);

    abstract <T, U, V> void biFunction(BiFunction<T, U, V> function);

    abstract void longBinaryOperator(LongBinaryOperator operator);

}
