package org.ashapatin.etl.transform;

import org.ashapatin.etl.model.WeatherAggregatedData;
import org.ashapatin.etl.model.WeatherData;

public class TransformWeather implements Transform<WeatherData, WeatherAggregatedData>{

  @Override
  public WeatherAggregatedData transform(WeatherData data) {
    return null;
  }

}
