package org.ashapatin.etl.extract;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import org.ashapatin.etl.extract.exception.IncorrectSourceInfoException;
import org.ashapatin.etl.model.WeatherData;

public class ExtractWeatherFromJson implements Extract<WeatherData> {
  @Override
  public WeatherData extract(String sourceInfo) throws IncorrectSourceInfoException, IOException {
    File file = openFile(sourceInfo);
    ObjectMapper mapper = new ObjectMapper();
    WeatherData weatherData = mapper.readValue(file, WeatherData.class);
    return weatherData;
  }

  private File openFile(String sourceInfo) throws IncorrectSourceInfoException {
    File file = new File(sourceInfo);
    validateFile(file);
    return file;
  }
  private void validateFile(File file) throws IncorrectSourceInfoException {
    if (!file.exists() || !file.isFile() || !file.canRead()) {
      throw new IncorrectSourceInfoException("Incorrect source info were specified. Please, "
          + "refer to the documentation for using correct source info.");
    }
  }
}
