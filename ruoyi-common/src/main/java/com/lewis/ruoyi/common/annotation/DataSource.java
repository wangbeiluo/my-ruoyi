package com.lewis.ruoyi.common.annotation;

import com.lewis.ruoyi.common.enums.DataSourceType;

import java.lang.annotation.*;

/**
 * @author lewis
 * @description: 自定义多数据源切换注解
 *
 * 优先级：先方法、后类，如果方法覆盖了类上的数据源类型，以方法的为准，否则以类上的为准
 *
 * @date: 2022/8/14
 * @Copyright:
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface DataSource
{
    public DataSourceType value() default DataSourceType.MASTER;
}
