
package dev;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
DruidDataSourceAutoConfigure会注入一个DataSourceWrapper，
        其会在原生的spring.datasource下找url,username,password等。
        而我们动态数据源的配置路径是变化的,所以需要排除*/
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@MapperScan({"dev.lpf.*.mapper"})
@ComponentScan({"dev.lpf"})
public class MPDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MPDemoApplication.class, args);
    }

}
