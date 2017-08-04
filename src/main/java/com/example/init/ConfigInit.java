package com.example.init;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 初始化常量
 * Created by zxh on 2016/12/13.
 */
@Component
public class ConfigInit implements CommandLineRunner{
    private Logger logger = LoggerFactory.getLogger(ConfigInit.class);
    @Autowired
    private Environment env;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("########start init config......");
        logger.info("########end init config");
    }
}
