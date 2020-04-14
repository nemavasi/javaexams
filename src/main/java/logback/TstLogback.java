package logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TstLogback {

  private static final Logger logger = LoggerFactory.getLogger(TstLogback.class);

  public static void main(String[] args) {
    logger.trace("trace Example log from {}", TstLogback.class.getSimpleName());
    logger.debug("debug Example log from {}", TstLogback.class.getSimpleName());
    logger.info("info Example log from {}", TstLogback.class.getSimpleName());
    logger.warn("warn Example log from {}", TstLogback.class.getSimpleName());
    logger.error("error Example log from {}", TstLogback.class.getSimpleName());
  }
}
