package com.example.demo_springmvc_resttemplate.services;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class PokemonService {

    private final RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public ResponseEntity<JsonNode> getPostsJsonNode(String pokemonName) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<JsonNode> entityString = restTemplate
                .getForEntity("pokemon/" + pokemonName, JsonNode.class);


        JsonNode body = entityString.getBody();

        return entityString;
    }


}
