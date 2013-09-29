package lv.ldn.java8;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {

    public static void jdk7(List<String> list) {
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });
    }

    public static void jdk8(List<String> list) {
        Collections.sort(list, (s1, s2) -> s1.length() - s2.length());
    }

}
