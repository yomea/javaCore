package com.log;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HighLevelLog {
	
	
	/**
	 * 日志记录具有包的结果，层次结构很强
	 * 通常，有以下七个日志记录器级别：
	 * 》server
	 * 》warning
	 * 》info
	 * 》config
	 * 》fine
	 * 》finer
	 * 》finest
	 * @param args
	 */
	public static void main(String[] args) {
		Logger logger = Logger.getLogger("HighLevelLog");
		
		logger.info("日志处理");
		logger.warning("日誌處理");
		logger.setLevel(Level.FINE);
		logger.fine("asfhlashg");
		logger.logp(Level.FINE, "com.log.HighLevelLog", "main", "Exception");
		logger.entering("com.log.HighLevelLog", "main");
		logger.setLevel(Level.OFF);//将会关闭所有的日志处理，下面的日志将不会打印
		logger.info("日志处理");
		logger.warning("日誌處理");
		
		
	}

}
