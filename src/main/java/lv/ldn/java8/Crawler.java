package lv.ldn.java8;

import java.net.URL;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class Crawler {

    protected abstract String download(URL url);

    protected abstract List<URL> findLinks(String html);

    public void crawl(List<URL> links, Consumer<Stream<URL>> consumer) {
        List<CompletableFuture<List<URL>>> futures = links.stream()
                .map(url -> CompletableFuture.supplyAsync(() -> download(url)))
                .map(future -> future.thenApply(this::findLinks))
                .collect(Collectors.toList());
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[futures.size()]))
                .thenApply(v -> futures.stream()
                        .flatMap(future -> future.join().stream()))
                .thenAccept(consumer);
    }

}
