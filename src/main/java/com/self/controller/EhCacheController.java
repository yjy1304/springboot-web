package com.self.controller;

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
        Cache<String, AtomicInteger> testCache = cacheManager.getCache("test1");
        if(testCache.get(key) == null){
            testCache.put(key, new AtomicInteger(0));
        }

        AtomicInteger ai = testCache.get(key);
        int i = ai.incrementAndGet();

        return "缓存值:" + i;
    }

}
