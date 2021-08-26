package com.example.kpm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShadiaoConfig {
    @Value("${shadiao.chp_url}")
    public String chp_url;
    @Value("${shadiao.pyq_url}")
    public String pyq_url;
    @Value("${shadiao.du_url}")
    public String du_url;
    @Value("${shadiao.nmsl_url}")
    public String nmsl_url;
    @Value("${shadiao.xh_url}")
    public String xh_url;
}
