package com.lewis.ruoyi.common.exception;

/**
 * @author lewis
 * @description: 工具类异常
 * @date: 2022/8/15
 * @Copyright:
 */
public class UtilException extends RuntimeException
{
    private static final long serialVersionUID = 8247610319171014183L;

    public UtilException(Throwable e)
    {
        super(e.getMessage(), e);
    }

    public UtilException(String message)
    {
        super(message);
    }

    public UtilException(String message, Throwable throwable)
    {
        super(message, throwable);
    }

}
