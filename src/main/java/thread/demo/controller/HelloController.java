package thread.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author yumingxiao1
 * @create 2019/7/9
 * @since 1.0.0
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello demo";
    }
}
