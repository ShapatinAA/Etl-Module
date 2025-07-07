package org.ashapatin.etl.transform;

import java.util.Arrays;
import java.util.Date;
import org.ashapatin.etl.model.WeatherAggregatedData;
import org.ashapatin.etl.model.WeatherData;

public class TransformWeather implements Transform<WeatherData, WeatherAggregatedData>{

  @Override
  public WeatherAggregatedData transform(WeatherData data2) {
    //TODO: change this to normal transformer
    WeatherAggregatedData data = new WeatherAggregatedData();

    // 24h averages
    data.setAvgTemperature2m24h(21.5);
    data.setAvgRelativeHumidity2m24h(65.0);
    data.setAvgDewPoint2m24h(14.3);
    data.setAvgApparentTemperature24h(22.0);
    data.setAvgTemperature80m24h(19.8);
    data.setAvgTemperature120m24h(18.6);
    data.setAvgWindSpeed10m24h(3.2);
    data.setAvgWindSpeed80m24h(5.5);
    data.setAvgVisibility24h(10000.0);
    data.setTotalRain24h(3.5);
    data.setTotalShowers24h(1.2);
    data.setTotalSnowfall24h(0.0);

    // Daylight averages
    data.setAvgTemperature2mDaylight(24.1);
    data.setAvgRelativeHumidity2mDaylight(60.2);
    data.setAvgDewPoint2mDaylight(13.7);
    data.setAvgApparentTemperatureDaylight(25.0);
    data.setAvgTemperature80mDaylight(21.3);
    data.setAvgTemperature120mDaylight(20.1);
    data.setAvgWindSpeed10mDaylight(3.7);
    data.setAvgWindSpeed80mDaylight(5.9);
    data.setAvgVisibilityDaylight(12000.0);
    data.setTotalRainDaylight(1.0);
    data.setTotalShowersDaylight(0.8);
    data.setTotalSnowfallDaylight(0.0);

    // Time-series (example lists with 3 timestamps)
    data.setWindSpeed10mMPerS(Arrays.asList(3.1, 2.8, 3.4));
    data.setWindSpeed80mMPerS(Arrays.asList(5.2, 5.0, 5.6));
    data.setTemperature2mCelsius(Arrays.asList(22.5, 21.8, 23.0));
    data.setApparentTemperatureCelsius(Arrays.asList(23.0, 22.2, 23.5));
    data.setTemperature80mCelsius(Arrays.asList(20.0, 19.5, 20.5));
    data.setTemperature120mCelsius(Arrays.asList(18.8, 18.3, 19.0));
    data.setSoilTemperature0cmCelsius(Arrays.asList(16.0, 16.5, 16.2));
    data.setSoilTemperature6cmCelsius(Arrays.asList(15.5, 15.8, 15.6));
    data.setRainMm(Arrays.asList(0.0, 0.5, 3.0));
    data.setShowersMm(Arrays.asList(0.0, 0.2, 1.0));
    data.setSnowfallMm(Arrays.asList(0.0, 0.0, 0.0));
    data.setDaylightHours(Arrays.asList(14.5, 14.6, 14.7));

    Date now = new Date(); // current timestamp
    data.setSunsetIso(Arrays.asList(now, now, now));
    data.setSunriseIso(Arrays.asList(now, now, now));

    return data;
  }

}
