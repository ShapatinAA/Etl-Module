package org.ashapatin.etl.extract;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import net.bytebuddy.asm.Advice.Local;
import org.ashapatin.etl.extract.exception.ExtractException;
import org.ashapatin.etl.extract.exception.IncorrectDatesParameterException;
import org.ashapatin.etl.extract.exception.UnableToExtractJsonFromApiException;
import org.ashapatin.etl.model.WeatherData;

public class ExtractWeatherFromApi implements Extract<WeatherData> {
  private static String url = "https://api.open-"
      + "meteo.com/v1/forecast?latitude=55.0344&longitude=82.9434&daily=sunrise,sunse"
      + "t,daylight_duration&hourly=temperature_2m,relative_humidity_2m,dew_point_2m,"
      + "apparent_temperature,temperature_80m,temperature_120m,wind_speed_10m,wind_sp"
      + "eed_80m,wind_direction_10m,wind_direction_80m,visibility,evapotranspiration,"
      + "weather_code,soil_temperature_0cm,soil_temperature_6cm,rain,showers,snowfall"
      + "&timezone=auto&timeformat=unixtime&wind_speed_unit=kn&temperature_unit=fahre"
      + "nheit&precipitation_unit=inch&start_date=2025-05-16&end_date=2025-05-30";

  @Override
  public WeatherData extract(String sourceInfo)
      throws UnableToExtractJsonFromApiException, IncorrectDatesParameterException {
    changeUrlAccordingToSourceInformation(sourceInfo);
    try {
      HttpClient httpClient = createHttpClient();
      HttpRequest httpRequest = createHttpRequest();
      HttpResponse httpResponse = getResponce(httpClient, httpRequest);

      WeatherData weatherData = getWeatherPojoFromResponce(httpResponse);
      return weatherData;
    } catch (IOException | InterruptedException e) {
      throw new UnableToExtractJsonFromApiException(e.getMessage(), e.getCause());
    }
  }

  private void changeUrlAccordingToSourceInformation(String sourceInfo)
      throws IncorrectDatesParameterException {
    if (sourceInfo.isBlank()) {
      return;
    }
    validateSourceInfo(sourceInfo);
    // именно такая форма для параметра для изменения временного интервала у api-запроса была
    // выбрана просто потому что это никак не специфицировано в задании.
    url = url.replace("&start_date=2025-05-16&end_date=2025-05-30", sourceInfo);
  }

  private void validateSourceInfo(String sourceInfo) throws IncorrectDatesParameterException {
    if (!sourceInfo.matches(
        "^&start_date=\\d{4}-\\d{2}-\\d{2}&end_date=\\d{4}-\\d{2}-\\d{2}$")) {
      throw new IncorrectDatesParameterException("Incorrect parameters for weather duration "
          + "were inserted. Please write them correctly");
    }
    try {
      LocalDate startDay = LocalDate.parse(sourceInfo.substring(12,22));
      LocalDate endDay = LocalDate.parse(sourceInfo.substring(32,42));
      if (startDay.isAfter(endDay) || startDay.isAfter(LocalDate.now())) {
        throw new IncorrectDatesParameterException("Incorrect parameters for weather duration "
            + "were inserted. Please write correct ones.");
      }
    } catch (DateTimeParseException e) {
      throw new IncorrectDatesParameterException(e.getMessage(), e.getCause());
    }

  }

  private HttpClient createHttpClient() {
    return HttpClient.newHttpClient();
  }

  private HttpRequest createHttpRequest() {
     HttpRequest httpRequestBuilder = HttpRequest.newBuilder()
         .GET()
         .uri(URI.create(url))
         .build();

    return httpRequestBuilder;
  }

  private HttpResponse getResponce(HttpClient httpClient, HttpRequest httpRequest)
      throws IOException, InterruptedException {
    return httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
  }

  private WeatherData getWeatherPojoFromResponce(HttpResponse httpResponse)
      throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(httpResponse.body().toString(), WeatherData.class);
  }
}
