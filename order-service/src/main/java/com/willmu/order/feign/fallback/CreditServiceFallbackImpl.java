package com.willmu.order.feign.fallback;

import com.willmu.order.feign.CreditService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author willmu
 * @date 2021/2/17 20:52
 */
@Slf4j
@Component
public class CreditServiceFallbackImpl implements CreditService {
    @Override
    public String add(String uid, Integer num) {
        log.info("用户{}，补偿积分数量：{}", uid, num);
        return "success";
    }
}
