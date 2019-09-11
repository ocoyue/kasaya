package com.ocoyue.cloud.p1.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Zoé
 * @date: 2019/9/11 下午12:22
 * @describe: TODO
 */


@Controller
public class ThymeleafController {


    @GetMapping("/thy")
    public String methodTest(Model model){
        model.addAttribute("name","张三");

        return "index";
    }
}
