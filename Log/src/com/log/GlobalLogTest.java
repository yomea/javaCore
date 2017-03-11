package com.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class GlobalLogTest {
	
	public static void main(String[] args) {
		
		Logger logger = Logger.getGlobal();
		
		logger.info("日志处理");
		logger.warning("日誌處理");
		logger.setLevel(Level.OFF);//将会关闭所有的日志处理，下面的日志将不会打印
		logger.info("日志处理");
		logger.warning("日誌處理");
	}

}
