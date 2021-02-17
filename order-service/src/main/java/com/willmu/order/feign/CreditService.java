package com.willmu.order.feign;

import com.willmu.order.feign.fallback.CreditServiceFallbackImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author willmu
 * @date 2021/2/17 20:52
 */
@FeignClient(name = "credit-service", fallback = CreditServiceFallbackImpl.class)
public interface CreditService {
    /** 增加积分
     * @param uid 用户id
     * @param num 积分数量
     * @return
     */
    @RequestMapping(value = "/credit/add/{uid}/{num}", method = RequestMethod.GET)
    String add(@PathVariable String uid, @PathVariable Integer num);
}
