package org.ashapatin.etl.extract.exception;

import java.io.IOException;

/**
 * <h2>UnableToExtractJsonFromApiException</h2>
 * <p><code>UnableToExtractJsonFromApiException</code> is an exception class. It indicates that
 * {@link IOException} or {@link InterruptedException} happen in the process of getting
 * http-response.</p>
 */
public class UnableToExtractJsonFromApiException extends ExtractException  {
  public UnableToExtractJsonFromApiException(String message) {
    super(message);
  }
  public UnableToExtractJsonFromApiException(String message, Throwable cause) {
    super(message, cause);
  }
  public UnableToExtractJsonFromApiException(Throwable cause) {
    super(cause);
  }
}
