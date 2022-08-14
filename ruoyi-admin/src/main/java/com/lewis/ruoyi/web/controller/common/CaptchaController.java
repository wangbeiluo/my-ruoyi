package com.lewis.ruoyi.web.controller.common;

import com.google.code.kaptcha.Producer;
import com.lewis.ruoyi.common.core.redis.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;

/**
 * @author lewis
 * @description:
 * @date: 2022/8/14
 * @Copyright:
 */
@RestController
public class CaptchaController {

    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;


}
