package com.lewis.ruoyi.common.exception.user;

import com.lewis.ruoyi.common.exception.base.BaseException;

/**
 * @author lewis
 * @description: 用户信息异常类
 * @date: 2022/8/17
 * @Copyright:
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
