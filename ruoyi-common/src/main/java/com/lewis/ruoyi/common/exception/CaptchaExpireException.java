package com.lewis.ruoyi.common.exception;


import com.lewis.ruoyi.common.exception.user.UserException;

/**
 * @author lewis
 * @description: 验证码失效异常类
 * @date: 2022/8/17
 * @Copyright:
 */
public class CaptchaExpireException extends UserException
{
    private static final long serialVersionUID = 1L;

    public CaptchaExpireException()
    {
        super("user.jcaptcha.expire", null);
    }
}
