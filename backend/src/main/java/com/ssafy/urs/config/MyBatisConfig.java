package com.ssafy.urs.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@MapperScan("com.ssafy.urs.model.dao")
@Configuration
public class MyBatisConfig {

}
