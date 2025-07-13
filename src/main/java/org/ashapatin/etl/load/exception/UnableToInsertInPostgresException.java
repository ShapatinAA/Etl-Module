package org.ashapatin.etl.load.exception;

/**
 * <h2>UnableToInsertInPostgresException</h2>
 * <p><code>UnableToInsertInPostgresException</code> is an exception class. It indicates that
 * program was unable to commit it's changes into postgres database.</p>
 */
public class UnableToInsertInPostgresException extends LoadException {

  public UnableToInsertInPostgresException(String message) {
    super(message);
  }
  public UnableToInsertInPostgresException(String message, Throwable cause) {
    super(message, cause);
  }
  public UnableToInsertInPostgresException(Throwable cause) {
    super(cause);
  }

}
