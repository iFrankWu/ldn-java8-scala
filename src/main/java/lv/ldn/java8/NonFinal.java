package lv.ldn.java8;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.LongAdder;

public class NonFinal {

    public static void mutable() {
        int count = 0;
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> {
            // count++;  -- won't compile
        });
    }

    public static void atomic() {
        LongAdder count = new LongAdder();
        List<String> strings = Arrays.asList("a", "b", "c");
        strings.forEach(s -> count.increment());
    }

}
