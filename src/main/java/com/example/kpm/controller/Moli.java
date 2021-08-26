package com.example.kpm.controller;

import com.example.kpm.config.StaticConfig;
import org.springframework.web.client.RestTemplate;

public class Moli {
    static RestTemplate restTemplate = new RestTemplate();

    public static String getAiRes(String word) {
        String limit = StaticConfig.moliConfigstatic.limit;
        String base_url = StaticConfig.moliConfigstatic.base_url;
        String api_key = StaticConfig.moliConfigstatic.api_key;
        String api_secret = StaticConfig.moliConfigstatic.api_secret;
        return restTemplate.getForObject(
                base_url + "question=" + word + "&limit=" + limit + "&api_key=" + api_key + "&api_secret=" + api_secret,
                String.class
        );
    }
}
