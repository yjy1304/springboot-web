package com.self.controller;

import com.self.entity.User;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wacai on 2016/3/9.
 */
@Controller
public class EhCacheController {
    @Autowired
    private CacheManager cacheManager;

    @RequestMapping(value="/ehcache/put/{key}")
    @ResponseBody
    private String put(@PathVariable("key") String key){
        Cache<String, User> testCache = cacheManager.getCache("testCache");
        User user = new User(new Long(1), key, "123");
        if(testCache.get(key) == null){
            testCache.put(key, user);
        }


        return "放入缓存值:" + user;
    }

    @RequestMapping(value="/ehcache/get/{key}")
    @ResponseBody
    private String get(@PathVariable("key") String key){
        Cache<String, User> testCache = cacheManager.getCache("testCache");
        User user = testCache.get(key);

        return "获得缓存值:" + user;
    }

}
