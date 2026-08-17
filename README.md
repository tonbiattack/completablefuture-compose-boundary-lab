# CompletableFutureのthenApplyとthenComposeを取り違える境界を実際にデバッグする

thenApply相当の処理はCompletableFuture<CompletableFuture<String>>を作る。非同期処理の結果を一つのCompletableFuture<String>へ平坦化するにはthenComposeを使う。修正前はFutureオブジェクトを文字列化し、期待する大文字文字列を返さない。

## 実行

修正前の失敗状態:

```bash
git checkout <bug-commit>
mvn test
```

修正後の確認:

```bash
git checkout <fix-commit>
mvn clean test
```

対象サービスは `src/main/java`、利用者視点のテストは `src/test/java`、実行証拠は `evidence/` にあります。
