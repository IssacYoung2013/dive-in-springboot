package com.issac.diveinspringboot.service;

/**
 * 计算服务
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
public interface CalculateService {

    /**
     * Sum 求和
     * @param values 多个整数
     * @return 累加值
     */
    Integer sum(Integer... values);
}
