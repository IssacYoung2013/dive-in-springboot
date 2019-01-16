package com.issac.diveinspringboot.repository;

import com.issac.diveinspringboot.annotation.FirstLevelRepository;
import com.issac.diveinspringboot.annotation.SecondLevelRepository;

/**
 *
 * author:  ywy
 * date:    2019-01-05
 * desc:
 */
@SecondLevelRepository(value = "myFirstLevelRepository")
public class MyFirstLevelRepository {
}
