package org.ashapatin.etl.load.exception;

/**
 * <h2>UnableToOpenCsvFileException</h2>
 * <p><code>UnableToOpenCsvFileException</code> is an exception class. It indicates that program was
 * unable to open .csv file for writing into.</p>
 */
public class UnableToOpenCsvFileException extends LoadException {

  public UnableToOpenCsvFileException(String message) {
    super(message);
  }
  public UnableToOpenCsvFileException(String message, Throwable cause) {
    super(message, cause);
  }
  public UnableToOpenCsvFileException(Throwable cause) {
    super(cause);
  }

}
