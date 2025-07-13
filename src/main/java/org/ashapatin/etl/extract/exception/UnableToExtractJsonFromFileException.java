package org.ashapatin.etl.extract.exception;

import java.io.IOException;

/**
 * <h2>UnableToExtractJsonFromFileException</h2>
 * <p><code>UnableToExtractJsonFromFileException</code> is an exception class. It indicates that
 * {@link IOException} happen in the process of getting mapping values from json file.</p>
 */
public class UnableToExtractJsonFromFileException extends ExtractException  {
  public UnableToExtractJsonFromFileException(String message) {
    super(message);
  }
  public UnableToExtractJsonFromFileException(String message, Throwable cause) {
    super(message, cause);
  }
  public UnableToExtractJsonFromFileException(Throwable cause) {
    super(cause);
  }
}
