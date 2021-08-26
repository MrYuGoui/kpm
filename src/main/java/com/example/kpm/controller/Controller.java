package com.example.kpm.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @Value("${res_poss}")
    static int res_poss;
    /*http://127.0.0.1:27149/api?content=谁啊&observer=机器猪*/
    @GetMapping("/api")
    public ResKw resKw(
            @RequestParam(value = "content", defaultValue = "在吗") String content,
            @RequestParam(value = "observer", defaultValue = "机器猪") String observer
    ) {
        String pretreat_respond = pretreat(content, observer);
        System.out.println(pretreat_respond);
        if (pretreat_respond.equals("")) {
            pretreat_respond = "在吗";
        }
        if (pretreat_respond.contains("need not to know")) {
            return new ResKw(400, "do not reply");
        }
        String respond = getCommonRes(pretreat_respond);
        if (respond.contains("turn to long wang")) {
            return new ResKw(300, "turn to long wang");
        } else {
            return new ResKw(200, respond);
        }
    }

    public static String pretreat(String words, String observer) {
        /*若存在引用内容，先进行过滤*/
        String split_kw = "- - - - - - - - - - - - - - -";
        if (words.contains(split_kw)) {
            String[] res = words.split(split_kw);
            words = res[1];
        }
        /*创建随机数，若低于阈值，则随机搭讪；否则只有在艾特或提及“我”才会回复*/
        long rp = Math.round(Math.random() * 100);
        if (words.contains(observer) || rp <= res_poss) {
            words = words.replace(observer, "").replace("@", "");
            return words;
        } else {
            return "need not to know";
        }
    }

    public static String getCommonRes(String words) {
        if (words.contains("彩虹屁")) {
            return Shadiao.getChp();
        } else if (words.contains("朋友圈")) {
            return Shadiao.getPyq();
        } else if (words.contains("鸡汤")) {
            return Shadiao.getDu();
        } else if (words.contains("骂街")) {
            return Shadiao.getNmsl();
        } else if (words.contains("笑话")) {
            return Shadiao.getXh();
//        } else if (words.contains("舔狗日记")) {
//            return Wpp.getTG();
//        } else if (words.contains("你好污")) {
//            return Wpp.getNW();
//        } else if (words.contains("古诗词")) {
//            return Wpp.getSC();
        } else if (words.contains("龙王")) {
            return "turn to long wang";
        } else if (words.contains("菜单")) {
            return "我可以识别以下关键字：菜单，彩虹屁，朋友圈，鸡汤，骂街，笑话，龙王。";
        } else {
            return Moli.getAiRes(words);
        }
    }
}
