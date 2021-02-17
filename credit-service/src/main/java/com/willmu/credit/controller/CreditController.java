package com.willmu.credit.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author willmu
 * @date 2021/2/17 20:49
 */
@RestController
@RequestMapping("/credit")
@Slf4j
public class CreditController {
    @RequestMapping(value = "/add/{uid}/{num}", method = RequestMethod.GET)
    public String add(@PathVariable String uid, @PathVariable Integer num) {
        log.info("用户{}增加积分{}", uid, num);
        return "success";
    }
}
