package lv.ldn.java8;

import java.util.List;
import java.util.stream.Collectors;

public class Fetch {

    /**
     * @see java.util.Spliterator
     */
    public static <K, V> List<V> jdk7(List<K> locations, Fetcher<K, V> fetcher) {
        return locations.parallelStream()
                .map(fetcher::fetch)
                .collect(Collectors.toList());
    }

    @FunctionalInterface
    private static interface Fetcher<K, V> {
        V fetch(K location);
    }

}
