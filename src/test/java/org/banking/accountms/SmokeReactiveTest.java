package org.banking.accountms;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

class SmokeReactiveTest {
    @Test
    void monoShouldEmitValue() {
        Mono<String> mono = Mono.just("ok");
        StepVerifier.create(mono)
            .expectNext("ok")
            .verifyComplete();
    }
}
