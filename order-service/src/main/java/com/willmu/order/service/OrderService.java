package com.willmu.order.service;

/**
 * @author willmu
 * @date 2021/2/17 10:50
 */
public interface OrderService {
    /** 下单
     * @param product 商品id
     * @param num 下单数量
     * @param uid 用户id
     * @param credit 增加积分
     * @return
     */
    String create(String product, Integer num, String uid, Integer credit);

}
