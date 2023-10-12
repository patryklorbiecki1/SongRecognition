package com.plorbiecki.songrecognition;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${x.rapid.api.key}")
    private String xRapidApiKey;
    @Value("${x.rapid.api.host}")
    private String xRapidApiHost;
    @Bean
    public WebClient getWebClient(WebClient.Builder webClientBuilder){
        return webClientBuilder
                .baseUrl("https://shazam.p.rapidapi.com/")
                .defaultHeader("X-RapidAPI-Key", xRapidApiKey)
                .defaultHeader("X-RapidAPI-Host", xRapidApiHost)
                .build();
    }
}
