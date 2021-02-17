package com.willmu.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author willmu
 * @date 2021/2/17 10:58
 */
@FeignClient(name = "stock-service")
public interface StockService {

    /** 扣减库存
     *  http://stock-serivce/stock/decrease/{product}/{num}
     * @param product 商品id
     * @param num 扣减数量
     * @return
     */
    @RequestMapping(value = "/stock/decrease/{product}/{num}", method = RequestMethod.GET)
    String decrease(@PathVariable String product, @PathVariable Integer num);
}
