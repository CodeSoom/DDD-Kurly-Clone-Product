package com.dddkurlyclone.product.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("promotion/discounts/products")
public class DiscountController {

    private WebClient.Builder webClientBuild;

    private String request_URL = "https://kurly-clone-promotion.codesoom.com/discounts/products";

    @GetMapping("/{id}")
    public String getDiscountedProduct(@RequestParam Long id) {
        Mono<String> mono = WebClient.builder().baseUrl(request_URL)
                .build().get()
                .uri(uriBuilder -> uriBuilder.path("/{id}.json")
                        .queryParam("productId",id)
                        .build())
                .exchangeToMono(clientResponse -> {
                    return clientResponse.bodyToMono(String.class);
                });
        return mono.block();
    }

}
