package org.ashapatin.etl.load.exception;

import org.ashapatin.etl.app.exception.EtlException;

/**
 * <h2>LoadException</h2>
 * <p><code>LoadException</code> is an general exception class for load functionality.
 * It indicates that something went wrong in context of load stage. It is preferred to throw
 * more specific exception among this class inheritances and not throw this one, as it is.</p>
 */
public class LoadException extends EtlException {
  public LoadException(String message) {
    super(message);
  }
  public LoadException(String message, Throwable cause) {
    super(message, cause);
  }
  public LoadException(Throwable cause) {
    super(cause);
  }

}