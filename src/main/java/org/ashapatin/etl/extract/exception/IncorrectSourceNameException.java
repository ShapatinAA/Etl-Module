package org.ashapatin.etl.extract.exception;

/**
 * <h2>IncorrectSourceNameException</h2>
 * <p><code>IncorrectSourceNameException</code> is an exception class. It indicates that incorrect
 * source for extraction was given as input parameter in command line for etl-module.</p>
 */
public class IncorrectSourceNameException extends ExtractException  {
  public IncorrectSourceNameException(String message) {
    super(message);
  }
  public IncorrectSourceNameException(String message, Throwable cause) {
    super(message, cause);
  }
  public IncorrectSourceNameException(Throwable cause) {
    super(cause);
  }
}
