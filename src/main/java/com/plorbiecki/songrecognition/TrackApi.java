package com.plorbiecki.songrecognition;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TrackApi {

    private final WebClient webClient;

    public TrackApi(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<List<Track>> getHits(String term) {
        return webClient
                .get()
                .uri("search?term=" + term)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(TrackResponse.class)
                .map(trackResponse -> trackResponse.getTracks().getHits())
                .flatMapMany(Flux::fromIterable)
                .map(Hit::getTrack).collectList();
    }
}
