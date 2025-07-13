package org.ashapatin.etl.transform;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.function.Function;
import java.util.stream.Stream;
import org.ashapatin.etl.model.Daily;
import org.ashapatin.etl.model.Hourly;
import org.ashapatin.etl.model.WeatherAggregatedData;
import org.ashapatin.etl.model.WeatherData;
import org.ashapatin.etl.transform.exception.IncorrectDataFromApiException;

public class TransformWeather implements Transform<WeatherData, WeatherAggregatedData[]> {
  @Override
  public WeatherAggregatedData[] transform(WeatherData data)
      throws IncorrectDataFromApiException {
    validateData(data);
    int nOfDays = data.getDaily().getTime().size();
    var weatherAggregatedDataBuilders = Stream.generate(WeatherAggregatedData::builder)
        .limit(nOfDays)
        .toList();
    WeatherAggregatedData[] weatherAggregatedDataList = new WeatherAggregatedData[nOfDays];
    for (int i = 0; i < nOfDays; i++) {
      var weatherAggregatedDataBuilder = weatherAggregatedDataBuilders.get(i);
      weatherAggregatedDataBuilder
          .avgTemperature2m24h(getAverage24h(data.getHourly().getTemperature2m(),
              TransformWeather::convertFahr2Cel, i))
          .avgRelativeHumidity2m24h(getAverage24h(data.getHourly().getRelativeHumidity2m().stream()
                  .map(Integer::doubleValue).toList(), TransformWeather::convertDouble2Double, i))
          .avgDewPoint2m24h(getAverage24h(data.getHourly().getDewPoint2m(),
              TransformWeather::convertFahr2Cel, i))
          .avgApparentTemperature24h(getAverage24h(data.getHourly().getApparentTemperature(),
              TransformWeather::convertFahr2Cel, i))
          .avgTemperature80m24h(getAverage24h(data.getHourly().getTemperature80m(),
              TransformWeather::convertFahr2Cel, i))
          .avgTemperature120m24h(getAverage24h(data.getHourly().getTemperature120m(),
              TransformWeather::convertFahr2Cel, i))
          .avgWindSpeed10m24h(getAverage24h(data.getHourly().getWindSpeed10m(),
              TransformWeather::convertKn2MPS, i))
          .avgWindSpeed80m24h(getAverage24h(data.getHourly().getWindSpeed80m(),
              TransformWeather::convertKn2MPS, i))
          .avgVisibility24h(getAverage24h(data.getHourly().getVisibility(),
              TransformWeather::convertFt2M, i))
          .totalRain24h(getTotal24h(data.getHourly().getRain(),
              TransformWeather::convertInToMm, i))
          .totalShowers24h(getTotal24h(data.getHourly().getShowers(),
              TransformWeather::convertInToMm, i))
          .totalSnowfall24h(getTotal24h(data.getHourly().getSnowfall(),
              TransformWeather::convertInToMm, i))
          .avgTemperature2mDaylight(getAverageDaylight(data.getHourly().getTemperature2m(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertFahr2Cel, i))
          .avgRelativeHumidity2mDaylight(getAverageDaylight(
              data.getHourly().getRelativeHumidity2m().stream().map(Integer::doubleValue).toList(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertDouble2Double, i))
          .avgDewPoint2mDaylight(getAverageDaylight(data.getHourly().getDewPoint2m(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertFahr2Cel, i))
          .avgApparentTemperatureDaylight(getAverageDaylight(
              data.getHourly().getApparentTemperature(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertFahr2Cel, i))
          .avgTemperature80mDaylight(getAverageDaylight(data.getHourly().getTemperature80m(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertFahr2Cel, i))
          .avgTemperature120mDaylight(getAverageDaylight(data.getHourly().getTemperature120m(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertFahr2Cel, i))
          .avgWindSpeed10mDaylight(getAverageDaylight(data.getHourly().getWindSpeed10m(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertKn2MPS, i))
          .avgWindSpeed80mDaylight(getAverageDaylight(data.getHourly().getWindSpeed80m(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertKn2MPS, i))
          .avgVisibilityDaylight(getAverageDaylight(data.getHourly().getVisibility(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertFt2M, i))
          .totalRainDaylight(getTotalDaylight(data.getHourly().getRain(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertInToMm, i))
          .totalShowersDaylight(getTotalDaylight(data.getHourly().getShowers(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertInToMm, i))
          .totalSnowfallDaylight(getTotalDaylight(data.getHourly().getSnowfall(),
              data.getDaily().getSunrise(), data.getDaily().getDaylightDuration(),
              data.getHourly().getTime(), TransformWeather::convertInToMm, i))
          .windSpeed10mMPerS(data.getHourly().getWindSpeed10m()
              .subList(i * 24, (i + 1) * 24).stream().map(TransformWeather::convertKn2MPS)
              .mapToDouble(Double::doubleValue).toArray())
          .windSpeed80mMPerS(data.getHourly().getWindSpeed10m()
              .subList(i * 24, (i + 1) * 24).stream().map(TransformWeather::convertKn2MPS)
              .mapToDouble(Double::doubleValue).toArray())
          .temperature2mCelsius(data.getHourly().getTemperature2m().subList(i * 24, (i + 1) * 24)
              .stream().map(TransformWeather::convertFahr2Cel)
              .mapToDouble(Double::doubleValue).toArray())
          .apparentTemperatureCelsius(data.getHourly().getApparentTemperature()
              .subList(i * 24, (i + 1) * 24).stream().map(TransformWeather::convertFahr2Cel)
              .mapToDouble(Double::doubleValue).toArray())
          .temperature80mCelsius(data.getHourly().getTemperature80m().subList(i * 24, (i + 1) * 24)
              .stream().map(TransformWeather::convertFahr2Cel)
              .mapToDouble(Double::doubleValue).toArray())
          .temperature120mCelsius(data.getHourly().getTemperature120m()
              .subList(i * 24, (i + 1) * 24).stream().map(TransformWeather::convertFahr2Cel)
              .mapToDouble(Double::doubleValue).toArray())
          .soilTemperature0cmCelsius(data.getHourly().getSoilTemperature0cm()
              .subList(i * 24, (i + 1) * 24).stream().map(TransformWeather::convertFahr2Cel)
              .mapToDouble(Double::doubleValue).toArray())
          .soilTemperature6cmCelsius(data.getHourly().getSoilTemperature6cm()
              .subList(i * 24, (i + 1) * 24).stream().map(TransformWeather::convertFahr2Cel)
              .mapToDouble(Double::doubleValue).toArray())
          .rainMm(data.getHourly().getRain().subList(i * 24, (i + 1) * 24)
              .stream().map(TransformWeather::convertInToMm)
              .mapToDouble(Double::doubleValue).toArray())
          .showersMm(data.getHourly().getShowers().subList(i * 24, (i + 1) * 24)
              .stream().map(TransformWeather::convertInToMm)
              .mapToDouble(Double::doubleValue).toArray())
          .snowfallMm(data.getHourly().getSnowfall().subList(i * 24, (i + 1) * 24).stream()
              .map(TransformWeather::convertInToMm).mapToDouble(Double::doubleValue).toArray())
          .daylightHours(getDaylight(data.getDaily().getSunset(), data.getDaily().getSunrise(), i))
          .sunsetIso(convertUnix2ISO(data.getDaily().getSunset().get(i).longValue()))
          .sunriseIso(convertUnix2ISO(data.getDaily().getSunrise().get(i).longValue()));
      weatherAggregatedDataList[i] = weatherAggregatedDataBuilder.build();
    }
    return weatherAggregatedDataList;
  }

  private void validateData(WeatherData data) throws IncorrectDataFromApiException {
    int numberOfDays = data.getDaily().getTime().size();
    if (numberOfDays != 0) {
      Hourly hourly = data.getHourly();
      Daily daily = data.getDaily();
      if (hourly.getTemperature2m().size() != numberOfDays * 24
          || hourly.getRelativeHumidity2m().size() != numberOfDays * 24
          || hourly.getDewPoint2m().size() != numberOfDays * 24
          || hourly.getApparentTemperature().size() != numberOfDays * 24
          || hourly.getTemperature80m().size() != numberOfDays * 24
          || hourly.getTemperature120m().size() != numberOfDays * 24
          || hourly.getWindSpeed10m().size() != numberOfDays * 24
          || hourly.getWindSpeed80m().size() != numberOfDays * 24
          || hourly.getVisibility().size() != numberOfDays * 24
          || hourly.getRain().size() != numberOfDays * 24
          || hourly.getShowers().size() != numberOfDays * 24
          || hourly.getSnowfall().size() != numberOfDays * 24
          || hourly.getSoilTemperature0cm().size() != numberOfDays * 24
          || hourly.getSoilTemperature6cm().size() != numberOfDays * 24
          || daily.getSunrise().size() != numberOfDays
          || daily.getSunset().size() != numberOfDays
          || daily.getDaylightDuration().size() != numberOfDays
          || hourly.getTemperature2m().contains(null)
          || hourly.getRelativeHumidity2m().contains(null)
          || hourly.getDewPoint2m().contains(null)
          || hourly.getApparentTemperature().contains(null)
          || hourly.getTemperature80m().contains(null)
          || hourly.getTemperature120m().contains(null)
          || hourly.getWindSpeed10m().contains(null)
          || hourly.getWindSpeed80m().contains(null)
          || hourly.getVisibility().contains(null)
          || hourly.getRain().contains(null)
          || hourly.getShowers().contains(null)
          || hourly.getSnowfall().contains(null)
          || hourly.getSoilTemperature0cm().contains(null)
          || hourly.getSoilTemperature6cm().contains(null)
          || daily.getSunrise().contains(null)
          || daily.getSunset().contains(null)
          || daily.getDaylightDuration().contains(null)) {
        throw new IncorrectDataFromApiException("Incorrect data from API were get. "
            + "Missing some values.");
      }
    }
  }

  private static Double getAverage24h(List<Double> inputList,
      Function<Double, Double> converter, int dayNumber) {
    Double acc = 0.0;
    for (int hour = 24 * dayNumber; hour < (dayNumber + 1) * 24; hour++) {
      acc += converter.apply(inputList.get(hour));
    }
    return acc/24;
  }

  private static Double getTotal24h(List<Double> inputList,
      Function<Double, Double> converter, int dayNumber) {
    Double acc = 0.0;
    for (int hour = 24 * dayNumber; hour < (dayNumber + 1) * 24; hour++) {
      acc += converter.apply(inputList.get(hour));
    }
    return acc;
  }

  private static Double getAverageDaylight(List<Double> inputList,
      List<Integer> sunrise, List<Double> daylightDuration, List<Integer> time,
      Function<Double, Double> converter, int dayNumber) {

    Double acc = 0.0;
    int numOfHours = 0;
    for (int j = dayNumber * 24;
        (time.get(j) < (sunrise.get(dayNumber) + daylightDuration.get(dayNumber).intValue()))
        && (j < (dayNumber + 1) * 24);
        j++) {
      if (time.get(j) > sunrise.get(dayNumber)) {
        acc += converter.apply(inputList.get(j));
        numOfHours++;
      }
    }

    if (numOfHours == 0) {
      return 0.0;
    }
    return acc/numOfHours;
  }

  private static Double getTotalDaylight(List<Double> inputList,
      List<Integer> sunrise, List<Double> daylightDuration, List<Integer> time,
      Function<Double, Double> converter, int dayNumber) {

      Double acc = 0.0;
      for (int j = dayNumber * 24;
          (time.get(j) < (sunrise.get(dayNumber) + daylightDuration.get(dayNumber).intValue()))
          && (j < (dayNumber + 1) * 24);
          j++) {
        if (time.get(j) > sunrise.get(dayNumber)) {
          acc += converter.apply(inputList.get(j));
        }
      }
    return acc;
  }

  private static Integer getDaylight(List<Integer> sunset, List<Integer> sunrise, int dayNumber) {
    return (sunset.get(dayNumber) - sunrise.get(dayNumber)) / 3600;
  }

  private static Double convertFahr2Cel(Double fahrenheit) {
    return (fahrenheit - 32) * 5 / 9;
  }

  private static Double convertKn2MPS(Double knot) {
    return knot / 1.94384001;
  }

  private static Double convertFt2M(Double foot) {
    return foot * 0.3048;
  }

  private static Double convertInToMm(Double inch) {
    return inch * 25.4;
  }

  private static Double convertDouble2Double(Double tmp) {
    return tmp;
  }

  private static LocalDateTime convertUnix2ISO(Long time) {
    return LocalDateTime.ofInstant(Instant.ofEpochMilli(time*1000),
        TimeZone.getTimeZone("GMT+7:00").toZoneId());
  }

}
