package com.tang.atpsimple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@ServletComponentScan
@MapperScan("com.tang.atpsimple.dao")
public class AtpSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtpSimpleApplication.class, args);
	}

}
