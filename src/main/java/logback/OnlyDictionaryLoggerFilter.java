package logback;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

import java.util.Arrays;

public class OnlyDictionaryLoggerFilter extends Filter<ILoggingEvent> {

  @Override
  public FilterReply decide(ILoggingEvent event) {
    System.out.println(event.getFormattedMessage());
    System.out.println(Arrays.toString(event.getArgumentArray()));
    System.out.println(event.getLoggerName());
    System.out.println(event.getMDCPropertyMap());
    if (event.getFormattedMessage().contains("Handbook")) {
      return FilterReply.ACCEPT;
    } else {
      return FilterReply.DENY;
    }
  }
}