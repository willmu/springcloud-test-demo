package com.willmu.order.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author willmu
 * @date 2021/2/16 14:30
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    final RestTemplate restTemplate;

    @Autowired
    public OrderController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping(value = "/decrease/{product}/{num}",method = RequestMethod.GET)
    public String decrease(@PathVariable String product, @PathVariable Integer num) {
        restTemplate.getForObject("http://localhost:9001/stock/decrease/" + product + "/" + num, String.class);
        return "success";
    }

    @RequestMapping(value = "/decrease2/{product}/{num}",method = RequestMethod.GET)
    public String decrease2(@PathVariable String product, @PathVariable Integer num) {
        return restTemplate.getForObject("http://stock-service/stock/decrease/" + product + "/" + num, String.class);
    }
}
