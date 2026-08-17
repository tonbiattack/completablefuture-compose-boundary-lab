package com.example.futurelab;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.concurrent.CompletableFuture;
import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
class FutureServiceTest {
 @Autowired FutureService service;
 @Test void compose_should_flatten_nested_async_result() {
   CompletableFuture<String> result = service.flat("a");
   assertThat(result.join()).isEqualTo("VALUE:A");
 }
 @Test void thenApply_like_nesting_is_not_the_same_contract() {
   CompletableFuture<CompletableFuture<String>> nested = service.nested("a");
   assertThat(nested.join().join()).isEqualTo("value:a");
 }
}
