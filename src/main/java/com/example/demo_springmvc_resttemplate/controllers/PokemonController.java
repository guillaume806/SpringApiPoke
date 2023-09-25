package com.example.demo_springmvc_resttemplate.controllers;

import com.example.demo_springmvc_resttemplate.models.PokemonDTO;
import com.example.demo_springmvc_resttemplate.services.PokemonService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PokemonController {

    private final PokemonService pokemonService;

    @Autowired
    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

//    @GetMapping("/pokemon")
//    public String getPokemonDetails(@RequestParam String name, Model model) {
//        Pokemon pokemon = pokemonService.getPokemonDetails(name);
//        model.addAttribute("pokemon", pokemon);
//        return "templates/pokemon";
//    }
    @GetMapping("/pokemon/{pokename}")
    public ResponseEntity<JsonNode> getPostsJsonNode(@PathVariable String pokename) {
        return pokemonService.getPostsJsonNode(pokename);
    }
}
