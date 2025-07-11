package org.ashapatin.etl.transform;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Function;
import org.ashapatin.etl.model.WeatherAggregatedData;
import org.ashapatin.etl.model.WeatherData;

public class TransformWeather implements Transform<WeatherData, WeatherAggregatedData>{
  @Override
  public WeatherAggregatedData transform(WeatherData data) {
    var weatherAggregatedDataBuilder = WeatherAggregatedData.builder();
    weatherAggregatedDataBuilder
        .avgTemperature2m24h(getAverage24h(data.getHourly().getTemperature2m(),
            TransformWeather::convertFahr2Cel))
        .avgRelativeHumidity2m24h(
            getAverage24h(data.getHourly().getRelativeHumidity2m().stream()
                .map(Integer::doubleValue).toList(), TransformWeather::convertDouble2Double))
        .avgDewPoint2m24h(getAverage24h(data.getHourly().getDewPoint2m(),
            TransformWeather::convertFahr2Cel))
        .avgApparentTemperature24h(getAverage24h(data.getHourly().getApparentTemperature(),
            TransformWeather::convertFahr2Cel))
        .avgTemperature80m24h(getAverage24h(data.getHourly().getTemperature80m(),
            TransformWeather::convertFahr2Cel))
        .avgTemperature120m24h(getAverage24h(data.getHourly().getTemperature120m(),
            TransformWeather::convertFahr2Cel))
        .avgWindSpeed10m24h(getAverage24h(data.getHourly().getWindSpeed10m(),
            TransformWeather::convertKn2MPS))
        .avgWindSpeed80m24h(getAverage24h(data.getHourly().getWindSpeed80m(),
            TransformWeather::convertKn2MPS))
        .avgVisibility24h(getAverage24h(data.getHourly().getVisibility(),
            TransformWeather::convertFt2M))
        .totalRain24h(getTotal24h(data.getHourly().getRain(),
            TransformWeather::convertInToMm))
        .totalShowers24h(getTotal24h(data.getHourly().getShowers(),
            TransformWeather::convertInToMm))
        .totalSnowfall24h(getTotal24h(data.getHourly().getSnowfall(),
            TransformWeather::convertInToMm))
        .avgTemperature2mDaylight(getAverageDaylight(data.getHourly().getTemperature2m(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertFahr2Cel))
        .avgRelativeHumidity2mDaylight(getAverageDaylight(
            data.getHourly().getRelativeHumidity2m().stream().map(Integer::doubleValue).toList(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertDouble2Double))
        .avgDewPoint2mDaylight(getAverageDaylight(data.getHourly().getDewPoint2m(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertFahr2Cel))
        .avgApparentTemperatureDaylight(getAverageDaylight(
            data.getHourly().getApparentTemperature(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertFahr2Cel))
        .avgTemperature80mDaylight(getAverageDaylight(data.getHourly().getTemperature80m(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertFahr2Cel))
        .avgTemperature120mDaylight(getAverageDaylight(data.getHourly().getTemperature120m(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertFahr2Cel))
        .avgWindSpeed10mDaylight(getAverageDaylight(data.getHourly().getWindSpeed10m(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertKn2MPS))
        .avgWindSpeed80mDaylight(getAverageDaylight(data.getHourly().getWindSpeed80m(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertKn2MPS))
        .avgVisibilityDaylight(getAverageDaylight(data.getHourly().getVisibility(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertFt2M))
        .totalRainDaylight(getTotalDaylight(data.getHourly().getRain(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertInToMm))
        .totalShowersDaylight(getTotalDaylight(data.getHourly().getShowers(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertInToMm))
        .totalSnowfallDaylight(getTotalDaylight(data.getHourly().getSnowfall(),
            data.getDaily().getSunrise(),data.getDaily().getDaylightDuration(),
            data.getHourly().getTime(), TransformWeather::convertInToMm))
        .windSpeed10mMPerS(data.getHourly().getWindSpeed10m().stream()
            .map(TransformWeather::convertKn2MPS).toList())
        .windSpeed80mMPerS(data.getHourly().getWindSpeed10m().stream()
            .map(TransformWeather::convertKn2MPS).toList())
        .temperature2mCelsius(data.getHourly().getTemperature2m().stream()
            .map(TransformWeather::convertFahr2Cel).toList())
        .apparentTemperatureCelsius(data.getHourly().getApparentTemperature().stream()
            .map(TransformWeather::convertFahr2Cel).toList())
        .temperature80mCelsius(data.getHourly().getTemperature80m().stream()
            .map(TransformWeather::convertFahr2Cel).toList())
        .temperature120mCelsius(data.getHourly().getTemperature120m().stream()
            .map(TransformWeather::convertFahr2Cel).toList())
        .soilTemperature0cmCelsius(data.getHourly().getSoilTemperature0cm().stream()
            .map(TransformWeather::convertFahr2Cel).toList())
        .soilTemperature6cmCelsius(data.getHourly().getSoilTemperature6cm().stream()
            .map(TransformWeather::convertFahr2Cel).toList())
        .rainMm(data.getHourly().getRain().stream().map(TransformWeather::convertInToMm).toList())
        .showersMm(data.getHourly().getShowers().stream()
            .map(TransformWeather::convertInToMm).toList())
        .snowfallMm(data.getHourly().getSnowfall().stream()
            .map(TransformWeather::convertInToMm).toList())
        .daylightHours(getDaylight(data.getDaily().getSunset(), data.getDaily().getSunrise()))
        .sunsetIso(data.getDaily().getSunset().stream()
            .map(Integer::longValue).map(TransformWeather::convertUnix2ISO).toList())
        .sunriseIso(data.getDaily().getSunrise().stream()
            .map(Integer::longValue).map(TransformWeather::convertUnix2ISO).toList());
    return weatherAggregatedDataBuilder.build();
  }


  private static List<Double> getAverage24h(List<Double> inputList,
      Function<Double, Double> converter) {
    List<Double> average24List = new ArrayList();
    Double acc = 0.0;
    for (int i = 0; i < inputList.size(); i++) {

      acc += converter.apply(inputList.get(i));

      if (i % 24 == 23) {
        average24List.add(acc/24);
        acc = 0.0;
      }
    }
    return average24List;
  }

  private static List<Double> getTotal24h(List<Double> inputList,
      Function<Double, Double> converter) {
    List<Double> average24List = new ArrayList();
    Double acc = 0.0;
    for (int i = 0; i < inputList.size(); i++) {

      acc += converter.apply(inputList.get(i));

      if (i % 24 == 23) {
        average24List.add(acc);
        acc = 0.0;
      }
    }
    return average24List;
  }

  private static List<Double> getAverageDaylight(List<Double> inputList,
      List<Integer> sunrise, List<Double> daylightDuration, List<Integer> time,
      Function<Double, Double> converter) {

    List<Double> averageDaylightList = new ArrayList();

    for (int i = 0; i < daylightDuration.size(); i++) {
      Double acc = 0.0;
      int numOfHours = 0;
      for (int j = i * 24; (time.get(j) < (sunrise.get(i) + daylightDuration.get(i).intValue()))
          && (j < (i + 1) * 24); j++) {
        if (time.get(j) > sunrise.get(i)) {
          acc += converter.apply(inputList.get(j));
          numOfHours++;
        }
      }
      if (numOfHours != 0) {
        averageDaylightList.add(acc/numOfHours);
      } else {
        averageDaylightList.add(0.0);
      }
    }
    return averageDaylightList;
  }

  private static List<Double> getTotalDaylight(List<Double> inputList,
      List<Integer> sunrise, List<Double> daylightDuration, List<Integer> time,
      Function<Double, Double> converter) {

    List<Double> averageDaylightList = new ArrayList();

    for (int i = 0; i < daylightDuration.size(); i++) {
      Double acc = 0.0;
      for (int j = i * 24; (time.get(j) < (sunrise.get(i) + daylightDuration.get(i).intValue()))
          && (j < (i + 1) * 24); j++) {
        if (time.get(j) > sunrise.get(i)) {
          acc += converter.apply(inputList.get(j));
        }
      }
      averageDaylightList.add(acc);
    }
    return averageDaylightList;
  }

  private static List<Integer> getDaylight(List<Integer> sunset, List<Integer> sunrise) {
    List<Integer> daylightHours = new ArrayList();
    for (int i = 0; i < sunset.size(); i++) {
      daylightHours.add((sunset.get(i) - sunrise.get(i)) / 3600);
    }
    return daylightHours;
  }

  private static Double convertFahr2Cel(Double temp) {
    return (temp - 32) * 5 / 9;
  }

  private static Double convertKn2MPS(Double speed) {
    return speed / 1.94384001;
  }

  private static Double convertFt2M(Double foot) {
    return foot * 0.3048;
  }

  private static Double convertInToMm(Double speed) {
    return speed / 1.94384001;
  }

  private static Double convertDouble2Double(Double tmp) {
    return tmp;
  }

  private static Date convertUnix2ISO(Long time) {
    return new Date(time * 1000);
  }

}
