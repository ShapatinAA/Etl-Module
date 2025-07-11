package org.ashapatin.etl.load;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import org.ashapatin.etl.load.exception.UnableToOpenCsvFile;
import org.ashapatin.etl.model.WeatherAggregatedData;

public class LoadToCsv implements Load<WeatherAggregatedData> {
  private final String csvFilePath = "./weather_result.csv";
  private final String datePattern = "yyyy-MM-dd'T'HH:mm'Z'";

  @Override
  public void load(WeatherAggregatedData data) throws Exception {
    try {
      CsvMapper csvMapper = createCsvMapper();
      CsvSchema csvWeatherSchema = createCsvSchema(csvMapper);

      writeToFile(csvMapper, csvWeatherSchema, data);
    }
    catch (IOException e) {
      throw new UnableToOpenCsvFile("Unable to open csv file on path: \"" + csvFilePath
          + "\". Try changing file path or checking permissions for creation.", e.getCause());
    }
  }

  private CsvMapper createCsvMapper() {
    DateFormat dateFormat = new SimpleDateFormat(datePattern);
    dateFormat.setTimeZone(java.util.TimeZone.getTimeZone("GMT+7"));

    CsvMapper csvMapper = new CsvMapper();
    csvMapper.setDateFormat(dateFormat);
    // otherwise quotes inconsistent
    // (see https://github.com/FasterXML/jackson-dataformats-text/issues/237)
    csvMapper.configure(CsvGenerator.Feature.STRICT_CHECK_FOR_QUOTING, true);
    return csvMapper;
  }

  private CsvSchema createCsvSchema(CsvMapper csvMapper) {
    CsvSchema csvWeatherSchema = csvMapper
        .typedSchemaFor(WeatherAggregatedData.class)
        .withColumnSeparator('\t')
        .withHeader();

    return csvWeatherSchema;
  }

  private void writeToFile(CsvMapper csvMapper,
      CsvSchema csvWeatherSchema, WeatherAggregatedData data) throws IOException {
    ObjectWriter csvWriter = csvMapper.writer(csvWeatherSchema);
    File csvFile = new File(csvFilePath);
    csvWriter.writeValue(csvFile, data);
  }
}
