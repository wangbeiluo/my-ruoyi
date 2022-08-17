package com.lewis.ruoyi.framework.web.service;

import com.lewis.ruoyi.common.constant.CacheConstants;
import com.lewis.ruoyi.common.constant.Constants;
import com.lewis.ruoyi.common.core.domain.entity.SysUser;
import com.lewis.ruoyi.common.core.redis.RedisCache;
import com.lewis.ruoyi.common.exception.CaptchaExpireException;
import com.lewis.ruoyi.common.exception.user.CaptchaException;
import com.lewis.ruoyi.common.utils.DateUtils;
import com.lewis.ruoyi.common.utils.MessageUtils;
import com.lewis.ruoyi.common.utils.ServletUtils;
import com.lewis.ruoyi.common.utils.StringUtils;
import com.lewis.ruoyi.common.utils.ip.IpUtils;
import com.lewis.ruoyi.framework.manager.AsyncManager;
import com.lewis.ruoyi.framework.manager.factory.AsyncFactory;
import com.lewis.ruoyi.system.service.ISysConfigService;
import com.lewis.ruoyi.system.service.ISysUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author lewis
 * @description: 登录校验方法
 * @date: 2022/8/15
 * @Copyright:
 */
@Component
public class SysLoginService
{
    @Autowired
    private TokenService tokenService;

    @Resource
    private AuthenticationManager authenticationManager;

    @Autowired
    private RedisCache redisCache;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private ISysConfigService configService;

    /**
     * 登陆验证
     *
     * @param username 用户名
     * @param password 密码
     * @param code 验证码
     * @param uuid 唯一标识
     * @return 结果
     */
    public String login(String username, String password, String code, String uuid)
    {
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        // 验证码开关
        if (captchaEnabled)
        {
            validateCaptcha(username, code, uuid);
        }
        // 用户验证
        Authentication authentication = null;
        try
        {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

        }
    }

    /**
     * 校验验证码
     *
     * @param username 用户名
     * @param code 验证码
     * @param uuid 唯一标识
     */
    public void validateCaptcha(String username, String code, String uuid)
    {
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + StringUtils.nvl(uuid, "");
        String captcha = redisCache.getCacheObject(verifyKey);
        redisCache.deleteObject(verifyKey);
        if (captcha == null)
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.expire")));
            throw new CaptchaExpireException();
        }
        if (!code.equalsIgnoreCase(captcha))
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(username, Constants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error")));
            throw new CaptchaException();
        }
    }

    /**
     * 记录登录信息
     *
     * @param userId 用户ID
     */
    public void recordLoginInfo(Long userId)
    {
        SysUser sysUser = new SysUser();
        sysUser.setUserId(userId);
        sysUser.setLoginIp(IpUtils.getIpAddr(ServletUtils.getRequest()));
        sysUser.setLoginDate(DateUtils.getNowDate());
        userService.updateUserProfile(sysUser);
    }
}
