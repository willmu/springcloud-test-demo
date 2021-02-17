package com.willmu.order.controller;

import com.willmu.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    private OrderService orderService;

    @Autowired
    public OrderController(RestTemplate restTemplate, OrderService orderService) {
        this.restTemplate = restTemplate;
        this.orderService = orderService;
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

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create(@RequestParam String product, @RequestParam Integer num,
                         @RequestParam Integer credit, @RequestParam String uid) {
        return orderService.create(product, num, uid, credit);
    }
}
