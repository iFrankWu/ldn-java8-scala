package lv.ldn.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lookup {

    public static <K, V> List<V> jdk7(List<K> list, Map<K, V> index) {
        List<V> result = new ArrayList<>(list.size());
        for (K key : list) {
            V value = index.get(key);
            if (value != null) {
                result.add(value);
            }
        }
        return result;
    }

    public static <K, V> List<V> jdk8(List<K> list, Map<K, V> index) {
        return list.stream()
                .map(index::get)
                .filter(value -> value != null)
                .collect(Collectors.toList());
    }

}
