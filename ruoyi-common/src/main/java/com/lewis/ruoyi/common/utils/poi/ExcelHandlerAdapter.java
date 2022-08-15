package com.lewis.ruoyi.common.utils.poi;

/**
 * @author lewis
 * @description: Excel数据格式处理适配器
 * @date: 2022/8/15
 * @Copyright:
 */
public interface ExcelHandlerAdapter
{
    /**
     * 格式化
     *
     * @param value 单元格数据值
     * @param args excel注解args参数组
     *
     * @return 处理后的值
     */
    Object format(Object value, String[] args);
}
