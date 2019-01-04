package com.iot.logtest.controller;

import com.iot.logtest.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author LHT
 */
@RestController
public class HomeController {

    private static Logger logger= LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private IUserService iUserService;

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello(){
        logger.info("控制器中的方法");
        logger.error("error信息");
        List<Integer> list=iUserService.getList();
        list.forEach(m-> logger.info(m.toString()));
        return "hello world";
    }

}
