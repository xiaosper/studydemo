package thread.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * helloworld demo
 * @author yumingxiao1
 * @create 2019/7/9
 * @since 1.0.0
 */
/*
@SpringBootApplication 标注主程序，说明为一个spring boot 应用
 */
@SpringBootApplication
public class HelloWorldMainApplication {
    public static void main(String[] args){
        //spring 应用启动
        SpringApplication.run(HelloWorldMainApplication.class);
    }
}
