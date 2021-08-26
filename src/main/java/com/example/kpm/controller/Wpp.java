package com.example.kpm.controller;

import com.example.kpm.config.StaticConfig;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSONObject;

public class Wpp {
    static RestTemplate restTemplate = new RestTemplate();
    static String base_url = StaticConfig.wppConfigstatic.base_url;

    public static String getTG() {
        String tg_url = StaticConfig.wppConfigstatic.tg_url;
        String res = restTemplate.getForObject(base_url + tg_url, String.class);
        return proResString(res);
    }

    public static String getNW() {
        String nw_url = StaticConfig.wppConfigstatic.nw_url;
        String res = restTemplate.getForObject(base_url + nw_url, String.class);
        return proResString(res);
    }

    public static String getSC() {
        String sc_url = StaticConfig.wppConfigstatic.sc_url;
        String res = restTemplate.getForObject(base_url + sc_url, String.class);
        return proResString(res);
    }

    public static String proResString(String string) {
        JSONObject object = JSONObject.parseObject(string);
        if (object.get("code").toString().equals("0")) {
            return object.get("data").toString();
        } else {
            return "你慢点说，卡死我啦！";
        }
    }
}
