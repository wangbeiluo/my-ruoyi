package com.lewis.ruoyi.common.exception.user;

/**
 * @author lewis
 * @description: 验证码错误异常类
 * @date: 2022/8/17
 * @Copyright:
 */
public class CaptchaException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaException()
    {
        super("user.jcaptcha.error", null);
    }
}
