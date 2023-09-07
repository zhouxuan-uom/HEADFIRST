package spring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by zhouxuan on 2023/9/7
 * 循环依赖
 * 1. 什么情况下能自动解决循环依赖
 * 2. 什么情况下不能自动解决循环依赖
 * @Author: zhouxuan
 * @Date: 2023/9/7
 */
@SpringBootApplication
public class SimpleStarter {
    public static void main(String[] args) {
        SpringApplication.run(SimpleStarter.class, args);
    }
}
