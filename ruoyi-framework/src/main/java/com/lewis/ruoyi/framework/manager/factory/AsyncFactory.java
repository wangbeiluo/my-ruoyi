package com.lewis.ruoyi.framework.manager.factory;

import com.lewis.ruoyi.common.constant.Constants;
import com.lewis.ruoyi.common.utils.LogUtils;
import com.lewis.ruoyi.common.utils.ServletUtils;
import com.lewis.ruoyi.common.utils.StringUtils;
import com.lewis.ruoyi.common.utils.ip.AddressUtils;
import com.lewis.ruoyi.common.utils.ip.IpUtils;
import com.lewis.ruoyi.common.utils.spring.SpringUtils;
import com.lewis.ruoyi.system.domain.SysLogininfor;
import com.lewis.ruoyi.system.service.ISysLogininforService;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * @author lewis
 * @description: 异步工厂（产生任务用）
 * @date: 2022/8/17
 * @Copyright:
 */
public class AsyncFactory
{
    private static final Logger sys_user_logger = LoggerFactory.getLogger("sys-user");

    // TimerTask: 可以由Timer安排一次或重复执行的任务。
    public static TimerTask recordLogininfor(final String username, final String status, final String message,
                                             final Object... args)
    {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = IpUtils.getIpAddr(ServletUtils.getRequest());
        return new TimerTask()
        {
            @Override
            public void run()
            {
                String address = AddressUtils.getRealAddressByIP(ip);
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(address);
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                sys_user_logger.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                SysLogininfor logininfor = new SysLogininfor();
                logininfor.setUserName(username);
                logininfor.setIpaddr(ip);
                logininfor.setLoginLocation(address);
                logininfor.setBrowser(browser);
                logininfor.setOs(os);
                logininfor.setMsg(message);
                // 日志状态
                /*
                * StringUtils.equalsAny: 判断多个字符串中是否有status对应的值
                * */
                if (StringUtils.equalsAny(status, Constants.LOGIN_SUCCESS, Constants.LOGOUT, Constants.REGISTER))
                {
                    logininfor.setStatus(Constants.SUCCESS);
                }
                else if (Constants.LOGIN_FAIL.equals(status))
                {
                    logininfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringUtils.getBean(ISysLogininforService.class).insertLogininfor(logininfor);
            }
        };
    }

}
