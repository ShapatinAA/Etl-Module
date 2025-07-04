package org.ashapatin.etl.load.exception;

import org.ashapatin.etl.extract.exception.ExtractException;

/**
 * <h2>IncorrectSourceNameException</h2>
 * <p><code>IncorrectSourceNameException</code> is an exception class. It indicates that incorrect
 * receiver for loading was given as input parameter in command line for etl-module.</p>
 */
public class IncorrectReceiverNameException extends ExtractException {
  public IncorrectReceiverNameException(String message) {
    super(message);
  }
  public IncorrectReceiverNameException(String message, Throwable cause) {
    super(message, cause);
  }
  public IncorrectReceiverNameException(Throwable cause) {
    super(cause);
  }
}
