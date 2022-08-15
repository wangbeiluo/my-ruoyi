package com.lewis.ruoyi.web.controller.system;

import com.lewis.ruoyi.common.config.RuoYiConfig;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lewis
 * @description: 登录验证
 * @date: 2022/8/15
 * @Copyright:
 */
@RestController
public class SysLoginController
{


    @GetMapping("/hello")
    public String hello()
    {
        String captchaType = RuoYiConfig.getCaptchaType();
        return captchaType;
    }
}
