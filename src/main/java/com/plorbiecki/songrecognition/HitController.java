package com.plorbiecki.songrecognition;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class HitController {
    private final TrackApi trackApi;

    public HitController(TrackApi trackApi) {
        this.trackApi = trackApi;
    }
    @GetMapping("/search")
    public Mono<List<Track>> getTrack(@RequestParam String term){
        return trackApi.getHits(term);
    }
}
