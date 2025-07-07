package org.ashapatin.etl.load.exception;

import org.ashapatin.etl.extract.exception.ExtractException;

/**
 * <h2>UnableToOpenCsvFile</h2>
 * <p><code>UnableToOpenCsvFile</code> is an exception class. It indicates that program was
 * unable to open .csv file for writing into.</p>
 */
public class UnableToOpenCsvFile extends LoadException{

  public UnableToOpenCsvFile(String message) {
    super(message);
  }
  public UnableToOpenCsvFile(String message, Throwable cause) {
    super(message, cause);
  }
  public UnableToOpenCsvFile(Throwable cause) {
    super(cause);
  }

}
