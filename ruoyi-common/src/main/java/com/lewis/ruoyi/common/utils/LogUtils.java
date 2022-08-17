package com.lewis.ruoyi.common.utils;

/**
 * @author lewis
 * @description: 处理并记录日志文件
 * @date: 2022/8/17
 * @Copyright:
 */
public class LogUtils
{
    public static String getBlock(Object msg)
    {
        if (msg == null)
        {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}