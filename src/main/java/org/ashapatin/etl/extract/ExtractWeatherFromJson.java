package org.ashapatin.etl.extract;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.ashapatin.etl.extract.exception.IncorrectSourceInfoException;
import org.ashapatin.etl.model.WeatherData;

public class ExtractWeatherFromJson implements Extract<WeatherData> {
  @Override
  public WeatherData extract(String sourceInfo) throws IncorrectSourceInfoException, IOException {
    File file = new File(sourceInfo);
    validateFile(file);
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(file, WeatherData.class);
  }
  private void validateFile(File file) throws IncorrectSourceInfoException {
    if (!file.exists() || !file.isFile() || !file.canRead()) {
      throw new IncorrectSourceInfoException("Incorrect source info were specified. Please, "
          + "refer to the documentation for using correct source info.");
    }
  }
}
