package org.ashapatin.etl.load;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvGenerator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import org.ashapatin.etl.load.exception.UnableToOpenCsvFile;
import org.ashapatin.etl.model.WeatherAggregatedData;
import org.ashapatin.etl.model.WeatherData;

public class LoadToCsv implements Load<WeatherAggregatedData> {
  private final String csvFilePath = "./weather_result.csv";
  private final String datePattern = "yyyy-MM-dd'T'HH:mm'Z'";

  @Override
  public void load(WeatherAggregatedData data) throws Exception {
    try {
      DateFormat dateFormat = new SimpleDateFormat(datePattern);

      CsvMapper csvMapper = new CsvMapper();
      csvMapper.setDateFormat(dateFormat);
      csvMapper.configure(CsvGenerator.Feature.STRICT_CHECK_FOR_QUOTING, true);

      CsvSchema csvWeatherSchema = csvMapper
          .typedSchemaFor(WeatherAggregatedData.class)
          .withColumnSeparator('\t')
          .withHeader();

      ObjectWriter csvWriter = csvMapper.writer(csvWeatherSchema);
      File csvFile = new File(csvFilePath);
      csvWriter.writeValue(csvFile, data);
    }
    catch (IOException e) {
      throw new UnableToOpenCsvFile("Unable to open csv file on path: \"" + csvFilePath
          + "\". Try changing file path or checking permissions for creation.", e.getCause());
    }
  }
}
