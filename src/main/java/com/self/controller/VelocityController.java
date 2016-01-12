package com.self.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wacai on 2016/1/7.
 */
@Controller
public class VelocityController {
    @RequestMapping(value="/index")
    public String index(Model model){
        String name="weilong";
        model.addAttribute("name", name);
        return "/index";
    }
}
