package com.example.vamojossa.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerManager {

        private static final Logger ERROR_LOGGER = LogManager.getRootLogger();
        private static final Logger INFO_LOGGER = LogManager.getLogger("info_logger");

        public static void info(String message) {

                INFO_LOGGER.info(message);
        }

        public static void error(String message) {

                ERROR_LOGGER.error(message);
        }

        public static void placeholder(){}
}
