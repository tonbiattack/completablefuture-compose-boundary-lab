package com.example.futurelab;

import org.springframework.stereotype.Service;
import java.util.concurrent.CompletableFuture;

@Service
public class FutureService {
    public CompletableFuture<String> fetch(String id) {
        return CompletableFuture.completedFuture("value:" + id);
    }

    public CompletableFuture<CompletableFuture<String>> nested(String id) {
        return CompletableFuture.completedFuture(fetch(id));
    }

    public CompletableFuture<String> flat(String id) {
        // 最小修正: 非同期結果をthenComposeで平坦化する
        return fetch(id).thenCompose(v -> CompletableFuture.completedFuture(v.toUpperCase()));
    }
}
