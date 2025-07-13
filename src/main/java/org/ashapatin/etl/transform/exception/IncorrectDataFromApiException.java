package org.ashapatin.etl.transform.exception;

public class IncorrectDataFromApiException extends TransformException {
  public IncorrectDataFromApiException(String message) {
    super(message);
  }
  public IncorrectDataFromApiException(String message, Throwable cause) {
    super(message, cause);
  }
  public IncorrectDataFromApiException(Throwable cause) {
    super(cause);
  }

}
