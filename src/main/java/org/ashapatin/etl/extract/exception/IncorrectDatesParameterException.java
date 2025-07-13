package org.ashapatin.etl.extract.exception;

/**
 * <h2>IncorrectDatesParameterException</h2>
 * <p><code>IncorrectDatesParameterException</code> is an exception class. It indicates that
 * parameters of dates for query were chosen incorrect.</p>
 */
public class IncorrectDatesParameterException extends ExtractException  {
  public IncorrectDatesParameterException(String message) {
    super(message);
  }
  public IncorrectDatesParameterException(String message, Throwable cause) {
    super(message, cause);
  }
  public IncorrectDatesParameterException(Throwable cause) {
    super(cause);
  }
}
