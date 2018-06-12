package cn.cout.pure.sframe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 扫描项目下面的 @WebFilter 和 @Web
@ServletComponentScan
public class SframeApplication {


	public static void main(String[] args) {
		SpringApplication.run(SframeApplication.class, args);
	}
}
