package com.example.kpm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WppConfig {
    @Value("${wpp.base_url}")
    public String base_url;
    @Value("${wpp.tg_url}")
    public String tg_url;
    @Value("${wpp.nw_url}")
    public String nw_url;
    @Value("${wpp.sc_url}")
    public String sc_url;
}
