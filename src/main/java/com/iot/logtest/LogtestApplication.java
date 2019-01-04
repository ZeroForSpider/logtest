package com.iot.logtest;

import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogtestApplication {

    private final static Logger logger = LoggerFactory.getLogger(LogtestApplication.class);

    public static void main(String[] args) {
        logger.info("项目启动中");
        SpringApplication.run(LogtestApplication.class, args);
    }

}

