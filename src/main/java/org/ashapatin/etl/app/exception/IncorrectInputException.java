package org.ashapatin.etl.app.exception;

/**
 * <h2>IncorrectInputException</h2>
 * <p><code>IncorrectInputException</code> is an exception class. It indicates that empty
 * input parameters in command line was given for etl-module.</p>
 */
public class IncorrectInputException extends EtlException {
  public IncorrectInputException(String message) {
    super(message);
  }
  public IncorrectInputException(String message, Throwable cause) {
    super(message, cause);
  }
  public IncorrectInputException(Throwable cause) {
    super(cause);
  }
}
