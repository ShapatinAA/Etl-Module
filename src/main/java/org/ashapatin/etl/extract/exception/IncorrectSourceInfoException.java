package org.ashapatin.etl.extract.exception;

/**
 * <h2>IncorrectSourceInfoException</h2>
 * <p><code>IncorrectSourceInfoException</code> is an exception class. It indicates that incorrect
 * info of source for extraction was given as input parameter in command line for etl-module.</p>
 */
public class IncorrectSourceInfoException extends ExtractException  {
  public IncorrectSourceInfoException(String message) {
    super(message);
  }
  public IncorrectSourceInfoException(String message, Throwable cause) {
    super(message, cause);
  }
  public IncorrectSourceInfoException(Throwable cause) {
    super(cause);
  }
}