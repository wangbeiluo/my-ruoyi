package com.lewis.ruoyi.web.controller.system;

import com.lewis.ruoyi.common.config.RuoYiConfig;
import com.lewis.ruoyi.common.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lewis
 * @description: 首页
 * @date: 2022/8/15
 * @Copyright:
 */
@RestController
public class SysIndexController
{
    /** 系统基础配置*/
    @Autowired
    private RuoYiConfig ruoYiConfig;

    /**
     * 访问首页，提示语
     */
    @RequestMapping("/")
    public String index()
    {
        return StringUtils.format("欢迎使用{}后台管理框架，当前版本：v{}，请通过前端地址访问。",ruoYiConfig.getName(), ruoYiConfig.getVersion());
    }
}
