package org.ashapatin.etl.extract;

import org.ashapatin.etl.extract.exception.IncorrectSourceNameException;

/**
 * <h2>ExtractFactory</h2>
 * <p>This is a factory-class of objects, which implements {@link Extract}
 * interface.</p>
 */
public final class ExtractFactory {
  public static Extract createExtractor(String sourceName) throws IncorrectSourceNameException {
    switch (sourceName) {
      case "json": {
        return new ExtractWeatherFromJson();
      }
      case "api": {
        return new ExtractWeatherFromApi();
      }
      default: {
        throw new IncorrectSourceNameException("Incorrect source name were specified. Please, "
            + "refer to the documentation for using correct source name.");
      }
    }
  }
}
