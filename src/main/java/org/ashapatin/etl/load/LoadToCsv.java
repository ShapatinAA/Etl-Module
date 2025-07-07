package org.ashapatin.etl.load;

import com.fasterxml.jackson.databind.ObjectWriter;
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

  @Override
  public void load(WeatherAggregatedData data) throws Exception {
    try {
      //TODO: refactor this
      CsvMapper mapper = new CsvMapper();
      TimeZone tz = TimeZone.getTimeZone("UTC");
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'"); // Quoted "Z" to indicate UTC, no timezone offset
      df.setTimeZone(tz);
      mapper.setDateFormat(df);
      CsvSchema schema = mapper.schemaFor(WeatherAggregatedData.class);
      schema = schema.withColumnSeparator('\t');

      ObjectWriter myObjectWriter = mapper.writer(schema);
      File tempFile = new File("weather_result.csv");
      FileOutputStream tempFileOutputStream = new FileOutputStream(tempFile);
      BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(tempFileOutputStream, 1024);
      OutputStreamWriter writerOutputStream = new OutputStreamWriter(bufferedOutputStream, "UTF-8");
      myObjectWriter.writeValue(writerOutputStream, data);
    }
    catch (IOException e) {
      throw new UnableToOpenCsvFile("Unable to open csv file on path: \"" + csvFilePath
          + "\". Try changing file path or checking permissions for creation.", e.getCause());
    }
  }
}
