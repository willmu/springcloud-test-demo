package com.willmu.stock.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author willmu
 * @date 2021/2/16 15:33
 */
@RestController
@RequestMapping("/stock")
@Slf4j
public class StockController {
    @RequestMapping(value = "/decrease/{product}/{num}", method = RequestMethod.GET)
    public String decrease(@PathVariable String product, @PathVariable Integer num) {
        log.info("商品{}扣减库存{}", product, num);
        return "success";
    }
}
