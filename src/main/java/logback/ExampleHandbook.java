package logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleHandbook extends ParentHandbook{

  private static final Logger logger = LoggerFactory.getLogger(ExampleHandbook.class);
  private static final Logger logger2 = LoggerFactory.getLogger("ru");

  public void foo(){
    logger.trace("trace Example log from {}", ExampleHandbook.class.getSimpleName());
    logger.debug("debug Example log from {}", ExampleHandbook.class.getSimpleName());
    logger.info("info Example log from {}", ExampleHandbook.class.getSimpleName());
    logger.warn("warn Example log from {}", ExampleHandbook.class.getSimpleName());
    logger.error("error Example log from {}", ExampleHandbook.class.getSimpleName());

    logger2.info("info Example log from {}", ExampleHandbook.class.getSimpleName());
  }
}
