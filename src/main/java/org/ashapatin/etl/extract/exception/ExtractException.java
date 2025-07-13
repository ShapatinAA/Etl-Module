package org.ashapatin.etl.extract.exception;

import org.ashapatin.etl.app.exception.EtlException;

/**
 * <h2>ExtractException</h2>
 * <p><code>ExtractException</code> is an general exception class for extract functionality.
 * It indicates that something went wrong in context of extraction stage. It is preferred to throw
 * more specific exception among this class inheritances and not throw this one, as it is.</p>
 */
public class ExtractException extends EtlException {
  public ExtractException(String message) {
    super(message);
  }
  public ExtractException(String message, Throwable cause) {
    super(message, cause);
  }
  public ExtractException(Throwable cause) {
    super(cause);
  }

}
