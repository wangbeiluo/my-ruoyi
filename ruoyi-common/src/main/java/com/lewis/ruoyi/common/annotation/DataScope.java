package com.lewis.ruoyi.common.annotation;

import java.lang.annotation.*;

/**
 * @author lewis
 * @description: 数据权限过滤注解
 * @date: 2022/8/17
 * @Copyright:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope
{
    /**
     * 部门表的别名
     */
    public String deptAlias() default "";

    /**
     * 用户表的别名
     */
    public String userAlias() default "";
}
