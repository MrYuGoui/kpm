package com.example.kpm.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.kpm.config.StaticConfig;
import org.springframework.web.client.RestTemplate;

public class Shadiao {
    static RestTemplate restTemplate = new RestTemplate();

    public static String getChp() {
        String chp_url = StaticConfig.shadiaoConfigstatic.chp_url;
        return restTemplate.getForObject(chp_url, String.class);
    }

    public static String getPyq() {
        String pyq_url = StaticConfig.shadiaoConfigstatic.pyq_url;
        return restTemplate.getForObject(pyq_url, String.class);
    }

    public static String getDu() {
        String du_url = StaticConfig.shadiaoConfigstatic.du_url;
        return restTemplate.getForObject(du_url, String.class);
    }

    public static String getNmsl() {
        String nmsl_url = StaticConfig.shadiaoConfigstatic.nmsl_url;
        return restTemplate.getForObject(nmsl_url, String.class);
    }

    public static String getXh() {
        String xh_url = StaticConfig.shadiaoConfigstatic.xh_url;
        String res = restTemplate.getForObject(xh_url, String.class);
        String res_rep = res.replace("\\", "").replace("<br>", "");
        String r = res_rep.substring(1, res_rep.length() - 1);
        JSONObject object = JSONObject.parseObject(r);
        if (object.get("success").toString().equals("获取段子成功")) {
            return object.get("duanzi").toString();
        } else {
            return "你慢点说，卡死我啦！";
        }
    }
}
