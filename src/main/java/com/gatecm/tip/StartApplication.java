package com.gatecm.tip;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @ClassName: StartApplication
 * @Description: TODO(启动)
 * @author chenxiaohui
 * @date 2017年12月10日 下午3:13:15
 *
 */
@SpringBootApplication
@ServletComponentScan
@EnableTransactionManagement
public class StartApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(StartApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
		app.run(args);
	}

}
