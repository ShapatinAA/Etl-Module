package org.ashapatin.etl.app.exception;

/**
 * <h2>EtlException</h2>
 * <p><code>EtlException</code> is an general exception class whole etl-module. It
 * indicates that something went wrong while in work of etl-module. It is preferred to throw
 * more specific exception among this class inheritances and not throw this one, as it is.</p>
 */
public class EtlException extends Exception {
  public EtlException() {

  }
  public EtlException(String message) {
    super(message);
  }
  public EtlException(String message, Throwable cause) {
    super(message, cause);
  }
  public EtlException(Throwable cause) {
    super(cause);
  }
}
