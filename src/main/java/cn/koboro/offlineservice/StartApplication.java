package cn.koboro.offlineservice;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * SpringBoot start
 * @author HSL
 */
@ServletComponentScan
@SpringBootApplication
@MapperScan(basePackages = "cn.koboro.offlineservice.repository")
public class StartApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplicationBuilder builder = new SpringApplicationBuilder();
        builder.sources(StartApplication.class);
        builder.bannerMode(Banner.Mode.OFF);
        builder.run(args); 
    }
}
