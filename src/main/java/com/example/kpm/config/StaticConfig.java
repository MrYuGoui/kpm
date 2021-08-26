package com.example.kpm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StaticConfig {
    public static MoliConfig moliConfigstatic;
    public static ShadiaoConfig shadiaoConfigstatic;
    @Autowired
    private MoliConfig moliConfig;
    @Autowired
    private ShadiaoConfig shadiaoConfig;

    @PostConstruct
    public void initStaticDao() {
        moliConfigstatic = this.moliConfig;
        shadiaoConfigstatic = this.shadiaoConfig;
    }
}
