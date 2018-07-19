package cn.cout.pure.sframe.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // localhost:8086/hello
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/hello")
    public String hello() {
        logger.info("2222");
        return "2222";
    }

    // 127.0.0.1:8086/tangjie?age=18
    @RequestMapping("/{name}")
    public String sayHi(@PathVariable String name, String age) {
        return "hi " + name + " age is " + age;
    }
}
