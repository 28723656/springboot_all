package com.java.springboot02config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot02ConfigApplicationTests {

	// 记录器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {
	  // 日志的级别由低到高
		logger.trace("trance日志：跟踪轨迹");
		logger.debug("debug日志：");
		logger.info("info日志");
		logger.warn("warn日志");
		logger.error("error日志");

	}

}
