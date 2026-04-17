package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackExamples {
    private static final Logger LOG = LoggerFactory.getLogger(LogbackExamples.class);
    private static final Logger LOG_2 = LoggerFactory.getLogger("org.example.LogbackExamples");

    public static void main(String[] args) {
        LOG.trace("Trace from LOG");
        LOG.info("Information from LOG_1");
        LOG_2.warn("Warning from LOG_2");
        LOG.info("Are the loggers the same? {}", LOG == LOG_2);
        LOG.info("My name is {}. {} {}.", "Bond", "James", "Bond");
        try {
            int result = 1 / 0;
        } catch (ArithmeticException e) {
            LOG.error("Something went wrong with divisor {}", 0, e);
        }
        LoggerLevelClass.log();
    }
}

class LoggerLevelClass {
    private static final Logger LOG = LoggerFactory.getLogger(LoggerLevelClass.class);

    public static void log() {
        LOG.trace("TRACE level message");
        LOG.debug("DEBUG level message");
        LOG.info("INFO level message");
        LOG.warn("WARN level message");
        LOG.error("ERROR level message");
    }
}