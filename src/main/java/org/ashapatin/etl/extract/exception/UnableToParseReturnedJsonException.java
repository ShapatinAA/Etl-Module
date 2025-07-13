package org.ashapatin.etl.extract.exception;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * <h2>UnableToParseReturnedJsonException</h2>
 * <p><code>UnableToParseReturnedJsonException</code> is an exception class. It indicates that
 * {@link JsonProcessingException} happen in the process of mapping json response onto
 * {@link org.ashapatin.etl.model.WeatherData} POJO.</p>
 */
public class UnableToParseReturnedJsonException extends ExtractException  {
  public UnableToParseReturnedJsonException(String message) {
    super(message);
  }
  public UnableToParseReturnedJsonException(String message, Throwable cause) {
    super(message, cause);
  }
  public UnableToParseReturnedJsonException(Throwable cause) {
    super(cause);
  }
}
