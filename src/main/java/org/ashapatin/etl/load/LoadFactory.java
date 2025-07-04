package org.ashapatin.etl.load;

import org.ashapatin.etl.load.exception.IncorrectReceiverNameException;

/**
 * <h2>LoadFactory</h2>
 * <p>This is a factory-class of objects, which implements {@link Load}
 * interface.</p>
 */
public final class LoadFactory {
  public static Load createLoader(String receiverName) throws IncorrectReceiverNameException {
    switch (receiverName) {
      case "csv": {
        return new LoadToCsv();
      }
      case "postgres": {
        return new LoadToPostgres();
      }
      default: {
        throw new IncorrectReceiverNameException("Incorrect receiver name were specified. Please, "
            + "refer to the documentation for using correct source name.");
      }
    }
  }
}
