package org.ashapatin.etl.transform.exception;

import org.ashapatin.etl.app.exception.EtlException;

public class TransformException extends EtlException {
  public TransformException(String message) {
    super(message);
  }
  public TransformException(String message, Throwable cause) {
    super(message, cause);
  }
  public TransformException(Throwable cause) {
    super(cause);
  }

}
