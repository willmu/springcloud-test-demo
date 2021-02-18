package com.willmu.order.service.impl;

import com.willmu.order.feign.CreditService;
import com.willmu.order.feign.StockService;
import com.willmu.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author willmu
 * @date 2021/2/17 10:56
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final StockService stockService;
    private final CreditService creditService;

    @Autowired
    public OrderServiceImpl(StockService stockService, CreditService creditService) {
        this.stockService = stockService;
        this.creditService = creditService;
    }

    /** 创建订单
     * @param product 商品id
     * @param num     下单数量
     * @param uid     用户id
     * @param credit  增加积分
     * @return
     */
    @Override
//    @Transactional
    @GlobalTransactional
    public String create(String product, Integer num, String uid, Integer credit) {
        log.info("创建订单成功");
        stockService.decrease(product, num);
        log.info("库存扣减成功");
        creditService.add(uid, credit);
        log.info("积分增加成功");
        return "success";
    }
}
