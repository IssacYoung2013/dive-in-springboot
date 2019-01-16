package com.issac.diveinspringboot.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@Profile("Java8")
@Service
public class Java8CalculateService implements CalculateService {
    @Override
    public Integer sum(Integer... values) {
        return Stream.of(values).reduce(0,Integer::sum);
    }

    public static void main(String[] args) {
        CalculateService calculateService = new Java8CalculateService();
        System.out.println(calculateService.sum(1,2,3,4,5,6,7,8,9,10));


    }
}
