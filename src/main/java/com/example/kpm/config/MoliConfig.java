package com.example.kpm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MoliConfig {
    @Value("${moli.limit}")
    public String limit;
    @Value("${moli.api_key}")
    public String api_key;
    @Value("${moli.api_secret}")
    public String api_secret;
    @Value("${moli.base_url}")
    public String base_url;
}
