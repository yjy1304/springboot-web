package com.self.controller;

import com.self.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wacai on 2016/1/7.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value="/create", method = {RequestMethod.POST})
    @ResponseBody
    public User view(User user) {
        logger.info("id:" + user.getId() + ",name=" + user.getName());
        return user;
    }
    @RequestMapping(value="/initUser")
    public String init(){
        return "/createUser";
    }

}
