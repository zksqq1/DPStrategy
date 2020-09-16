package com.tdxk.dp.controller;

import com.tdxk.dp.mapper.TestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author lin.
 */
@RestController
public class TestController {
    private TestMapper testMapper;
    private TestControllerB controllerB;
    @Autowired
    private Person person;

    @Bean(initMethod = "initMethod", destroyMethod = "destroyMethod")
    public Person person() {
        return new Person();
    }
    @Autowired
    public void setControllerB(TestControllerB controllerB) {
        this.controllerB = controllerB;
    }

//    @Autowired
    public TestController(TestMapper testMapper) {
        this.testMapper = testMapper;
    }

//    @Autowired
//    public TestController(TestControllerB controllerB) {
//        this.controllerB = controllerB;
//    }

    @GetMapping("/test")
    public String test() {
//        System.out.println(testMapper);
        return "test";
    }
}
