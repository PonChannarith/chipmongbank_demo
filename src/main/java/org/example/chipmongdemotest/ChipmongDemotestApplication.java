package org.example.chipmongdemotest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("org.example.chipmongdemotest.repository")
public class ChipmongDemotestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChipmongDemotestApplication.class, args);
	}

}
