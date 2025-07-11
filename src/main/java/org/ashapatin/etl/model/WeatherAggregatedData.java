package org.ashapatin.etl.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Date;
import java.util.List;
import lombok.Builder;

@JsonPropertyOrder({
    "avg_temperature_2m_24h",
    "avg_relative_humidity_2m_24h",
    "avg_dew_point_2m_24h",
    "avg_apparent_temperature_24h",
    "avg_temperature_80m_24h",
    "avg_temperature_120m_24h",
    "avg_wind_speed_10m_24h",
    "avg_wind_speed_80m_24h",
    "avg_visibility_24h",
    "total_rain_24h",
    "total_showers_24h",
    "total_snowfall_24h",
    "avg_temperature_2m_daylight",
    "avg_relative_humidity_2m_daylight",
    "avg_dew_point_2m_daylight",
    "avg_apparent_temperature_daylight",
    "avg_temperature_80m_daylight",
    "avg_temperature_120m_daylight",
    "avg_wind_speed_10m_daylight",
    "avg_wind_speed_80m_daylight",
    "avg_visibility_daylight",
    "total_rain_daylight",
    "total_showers_daylight",
    "total_snowfall_daylight",
    "wind_speed_10m_m_per_s",
    "wind_speed_80m_m_per_s",
    "temperature_2m_celsius",
    "apparent_temperature_celsius",
    "temperature_80m_celsius",
    "temperature_120m_celsius",
    "soil_temperature_0cm_celsius",
    "soil_temperature_6cm_celsius",
    "rain_mm",
    "showers_mm",
    "snowfall_mm",
    "daylight_hours",
    "sunset_iso",
    "sunrise_iso"
})
@Builder
public class WeatherAggregatedData {

  @JsonProperty("avg_temperature_2m_24h")
  private List<Double> avgTemperature2m24h;

  @JsonProperty("avg_relative_humidity_2m_24h")
  private List<Double> avgRelativeHumidity2m24h;

  @JsonProperty("avg_dew_point_2m_24h")
  private List<Double> avgDewPoint2m24h;

  @JsonProperty("avg_apparent_temperature_24h")
  private List<Double> avgApparentTemperature24h;

  @JsonProperty("avg_temperature_80m_24h")
  private List<Double> avgTemperature80m24h;

  @JsonProperty("avg_temperature_120m_24h")
  private List<Double> avgTemperature120m24h;

  @JsonProperty("avg_wind_speed_10m_24h")
  private List<Double> avgWindSpeed10m24h;

  @JsonProperty("avg_wind_speed_80m_24h")
  private List<Double> avgWindSpeed80m24h;

  @JsonProperty("avg_visibility_24h")
  private List<Double> avgVisibility24h;

  @JsonProperty("total_rain_24h")
  private List<Double> totalRain24h;

  @JsonProperty("total_showers_24h")
  private List<Double> totalShowers24h;

  @JsonProperty("total_snowfall_24h")
  private List<Double> totalSnowfall24h;

  @JsonProperty("avg_temperature_2m_daylight")
  private List<Double> avgTemperature2mDaylight;

  @JsonProperty("avg_relative_humidity_2m_daylight")
  private List<Double> avgRelativeHumidity2mDaylight;

  @JsonProperty("avg_dew_point_2m_daylight")
  private List<Double> avgDewPoint2mDaylight;

  @JsonProperty("avg_apparent_temperature_daylight")
  private List<Double> avgApparentTemperatureDaylight;

  @JsonProperty("avg_temperature_80m_daylight")
  private List<Double> avgTemperature80mDaylight;

  @JsonProperty("avg_temperature_120m_daylight")
  private List<Double> avgTemperature120mDaylight;

  @JsonProperty("avg_wind_speed_10m_daylight")
  private List<Double> avgWindSpeed10mDaylight;

  @JsonProperty("avg_wind_speed_80m_daylight")
  private List<Double> avgWindSpeed80mDaylight;

  @JsonProperty("avg_visibility_daylight")
  private List<Double> avgVisibilityDaylight;

  @JsonProperty("total_rain_daylight")
  private List<Double> totalRainDaylight;

  @JsonProperty("total_showers_daylight")
  private List<Double> totalShowersDaylight;

  @JsonProperty("total_snowfall_daylight")
  private List<Double> totalSnowfallDaylight;

  @JsonProperty("wind_speed_10m_m_per_s")
  private List<Double> windSpeed10mMPerS;

  @JsonProperty("wind_speed_80m_m_per_s")
  private List<Double> windSpeed80mMPerS;

  @JsonProperty("temperature_2m_celsius")
  private List<Double> temperature2mCelsius;

  @JsonProperty("apparent_temperature_celsius")
  private List<Double> apparentTemperatureCelsius;

  @JsonProperty("temperature_80m_celsius")
  private List<Double> temperature80mCelsius;

  @JsonProperty("temperature_120m_celsius")
  private List<Double> temperature120mCelsius;

  @JsonProperty("soil_temperature_0cm_celsius")
  private List<Double> soilTemperature0cmCelsius;

  @JsonProperty("soil_temperature_6cm_celsius")
  private List<Double> soilTemperature6cmCelsius;

  @JsonProperty("rain_mm")
  private List<Double> rainMm;

  @JsonProperty("showers_mm")
  private List<Double> showersMm;

  @JsonProperty("snowfall_mm")
  private List<Double> snowfallMm;

  @JsonProperty("daylight_hours")
  private List<Integer> daylightHours;

  @JsonProperty("sunset_iso")
  private List<Date> sunsetIso;

  @JsonProperty("sunrise_iso")
  private List<Date> sunriseIso;

  @JsonProperty("avg_temperature_2m_24h")
  public List<Double> getAvgTemperature2m24h() {
    return avgTemperature2m24h;
  }

  @JsonProperty("avg_temperature_2m_24h")
  public void setAvgTemperature2m24h(List<Double> avgTemperature2m24h) {
    this.avgTemperature2m24h = avgTemperature2m24h;
  }

  @JsonProperty("avg_relative_humidity_2m_24h")
  public List<Double> getAvgRelativeHumidity2m24h() {
    return avgRelativeHumidity2m24h;
  }

  @JsonProperty("avg_relative_humidity_2m_24h")
  public void setAvgRelativeHumidity2m24h(List<Double> avgRelativeHumidity2m24h) {
    this.avgRelativeHumidity2m24h = avgRelativeHumidity2m24h;
  }

  @JsonProperty("avg_dew_point_2m_24h")
  public List<Double> getAvgDewPoint2m24h() {
    return avgDewPoint2m24h;
  }

  @JsonProperty("avg_dew_point_2m_24h")
  public void setAvgDewPoint2m24h(List<Double> avgDewPoint2m24h) {
    this.avgDewPoint2m24h = avgDewPoint2m24h;
  }

  @JsonProperty("avg_apparent_temperature_24h")
  public List<Double> getAvgApparentTemperature24h() {
    return avgApparentTemperature24h;
  }

  @JsonProperty("avg_apparent_temperature_24h")
  public void setAvgApparentTemperature24h(List<Double> avgApparentTemperature24h) {
    this.avgApparentTemperature24h = avgApparentTemperature24h;
  }

  @JsonProperty("avg_temperature_80m_24h")
  public List<Double> getAvgTemperature80m24h() {
    return avgTemperature80m24h;
  }

  @JsonProperty("avg_temperature_80m_24h")
  public void setAvgTemperature80m24h(List<Double> avgTemperature80m24h) {
    this.avgTemperature80m24h = avgTemperature80m24h;
  }

  @JsonProperty("avg_temperature_120m_24h")
  public List<Double> getAvgTemperature120m24h() {
    return avgTemperature120m24h;
  }

  @JsonProperty("avg_temperature_120m_24h")
  public void setAvgTemperature120m24h(List<Double> avgTemperature120m24h) {
    this.avgTemperature120m24h = avgTemperature120m24h;
  }

  @JsonProperty("avg_wind_speed_10m_24h")
  public List<Double> getAvgWindSpeed10m24h() {
    return avgWindSpeed10m24h;
  }

  @JsonProperty("avg_wind_speed_10m_24h")
  public void setAvgWindSpeed10m24h(List<Double> avgWindSpeed10m24h) {
    this.avgWindSpeed10m24h = avgWindSpeed10m24h;
  }

  @JsonProperty("avg_wind_speed_80m_24h")
  public List<Double> getAvgWindSpeed80m24h() {
    return avgWindSpeed80m24h;
  }

  @JsonProperty("avg_wind_speed_80m_24h")
  public void setAvgWindSpeed80m24h(List<Double> avgWindSpeed80m24h) {
    this.avgWindSpeed80m24h = avgWindSpeed80m24h;
  }

  @JsonProperty("avg_visibility_24h")
  public List<Double> getAvgVisibility24h() {
    return avgVisibility24h;
  }

  @JsonProperty("avg_visibility_24h")
  public void setAvgVisibility24h(List<Double> avgVisibility24h) {
    this.avgVisibility24h = avgVisibility24h;
  }

  @JsonProperty("total_rain_24h")
  public List<Double> getTotalRain24h() {
    return totalRain24h;
  }

  @JsonProperty("total_rain_24h")
  public void setTotalRain24h(List<Double> totalRain24h) {
    this.totalRain24h = totalRain24h;
  }

  @JsonProperty("total_showers_24h")
  public List<Double> getTotalShowers24h() {
    return totalShowers24h;
  }

  @JsonProperty("total_showers_24h")
  public void setTotalShowers24h(List<Double> totalShowers24h) {
    this.totalShowers24h = totalShowers24h;
  }

  @JsonProperty("total_snowfall_24h")
  public List<Double> getTotalSnowfall24h() {
    return totalSnowfall24h;
  }

  @JsonProperty("total_snowfall_24h")
  public void setTotalSnowfall24h(List<Double> totalSnowfall24h) {
    this.totalSnowfall24h = totalSnowfall24h;
  }

  @JsonProperty("avg_temperature_2m_daylight")
  public List<Double> getAvgTemperature2mDaylight() {
    return avgTemperature2mDaylight;
  }

  @JsonProperty("avg_temperature_2m_daylight")
  public void setAvgTemperature2mDaylight(List<Double> avgTemperature2mDaylight) {
    this.avgTemperature2mDaylight = avgTemperature2mDaylight;
  }

  @JsonProperty("avg_relative_humidity_2m_daylight")
  public List<Double> getAvgRelativeHumidity2mDaylight() {
    return avgRelativeHumidity2mDaylight;
  }

  @JsonProperty("avg_relative_humidity_2m_daylight")
  public void setAvgRelativeHumidity2mDaylight(List<Double> avgRelativeHumidity2mDaylight) {
    this.avgRelativeHumidity2mDaylight = avgRelativeHumidity2mDaylight;
  }

  @JsonProperty("avg_dew_point_2m_daylight")
  public List<Double> getAvgDewPoint2mDaylight() {
    return avgDewPoint2mDaylight;
  }

  @JsonProperty("avg_dew_point_2m_daylight")
  public void setAvgDewPoint2mDaylight(List<Double> avgDewPoint2mDaylight) {
    this.avgDewPoint2mDaylight = avgDewPoint2mDaylight;
  }

  @JsonProperty("avg_apparent_temperature_daylight")
  public List<Double> getAvgApparentTemperatureDaylight() {
    return avgApparentTemperatureDaylight;
  }

  @JsonProperty("avg_apparent_temperature_daylight")
  public void setAvgApparentTemperatureDaylight(List<Double> avgApparentTemperatureDaylight) {
    this.avgApparentTemperatureDaylight = avgApparentTemperatureDaylight;
  }

  @JsonProperty("avg_temperature_80m_daylight")
  public List<Double> getAvgTemperature80mDaylight() {
    return avgTemperature80mDaylight;
  }

  @JsonProperty("avg_temperature_80m_daylight")
  public void setAvgTemperature80mDaylight(List<Double> avgTemperature80mDaylight) {
    this.avgTemperature80mDaylight = avgTemperature80mDaylight;
  }

  @JsonProperty("avg_temperature_120m_daylight")
  public List<Double> getAvgTemperature120mDaylight() {
    return avgTemperature120mDaylight;
  }

  @JsonProperty("avg_temperature_120m_daylight")
  public void setAvgTemperature120mDaylight(List<Double> avgTemperature120mDaylight) {
    this.avgTemperature120mDaylight = avgTemperature120mDaylight;
  }

  @JsonProperty("avg_wind_speed_10m_daylight")
  public List<Double> getAvgWindSpeed10mDaylight() {
    return avgWindSpeed10mDaylight;
  }

  @JsonProperty("avg_wind_speed_10m_daylight")
  public void setAvgWindSpeed10mDaylight(List<Double> avgWindSpeed10mDaylight) {
    this.avgWindSpeed10mDaylight = avgWindSpeed10mDaylight;
  }

  @JsonProperty("avg_wind_speed_80m_daylight")
  public List<Double> getAvgWindSpeed80mDaylight() {
    return avgWindSpeed80mDaylight;
  }

  @JsonProperty("avg_wind_speed_80m_daylight")
  public void setAvgWindSpeed80mDaylight(List<Double> avgWindSpeed80mDaylight) {
    this.avgWindSpeed80mDaylight = avgWindSpeed80mDaylight;
  }

  @JsonProperty("avg_visibility_daylight")
  public List<Double> getAvgVisibilityDaylight() {
    return avgVisibilityDaylight;
  }

  @JsonProperty("avg_visibility_daylight")
  public void setAvgVisibilityDaylight(List<Double> avgVisibilityDaylight) {
    this.avgVisibilityDaylight = avgVisibilityDaylight;
  }

  @JsonProperty("total_rain_daylight")
  public List<Double> getTotalRainDaylight() {
    return totalRainDaylight;
  }

  @JsonProperty("total_rain_daylight")
  public void setTotalRainDaylight(List<Double> totalRainDaylight) {
    this.totalRainDaylight = totalRainDaylight;
  }

  @JsonProperty("total_showers_daylight")
  public List<Double> getTotalShowersDaylight() {
    return totalShowersDaylight;
  }

  @JsonProperty("total_showers_daylight")
  public void setTotalShowersDaylight(List<Double> totalShowersDaylight) {
    this.totalShowersDaylight = totalShowersDaylight;
  }

  @JsonProperty("total_snowfall_daylight")
  public List<Double> getTotalSnowfallDaylight() {
    return totalSnowfallDaylight;
  }

  @JsonProperty("total_snowfall_daylight")
  public void setTotalSnowfallDaylight(List<Double> totalSnowfallDaylight) {
    this.totalSnowfallDaylight = totalSnowfallDaylight;
  }

  @JsonProperty("wind_speed_10m_m_per_s")
  public List<Double> getWindSpeed10mMPerS() {
    return windSpeed10mMPerS;
  }

  @JsonProperty("wind_speed_10m_m_per_s")
  public void setWindSpeed10mMPerS(List<Double> windSpeed10mMPerS) {
    this.windSpeed10mMPerS = windSpeed10mMPerS;
  }

  @JsonProperty("wind_speed_80m_m_per_s")
  public List<Double> getWindSpeed80mMPerS() {
    return windSpeed80mMPerS;
  }

  @JsonProperty("wind_speed_80m_m_per_s")
  public void setWindSpeed80mMPerS(List<Double> windSpeed80mMPerS) {
    this.windSpeed80mMPerS = windSpeed80mMPerS;
  }

  @JsonProperty("temperature_2m_celsius")
  public List<Double> getTemperature2mCelsius() {
    return temperature2mCelsius;
  }

  @JsonProperty("temperature_2m_celsius")
  public void setTemperature2mCelsius(List<Double> temperature2mCelsius) {
    this.temperature2mCelsius = temperature2mCelsius;
  }

  @JsonProperty("apparent_temperature_celsius")
  public List<Double> getApparentTemperatureCelsius() {
    return apparentTemperatureCelsius;
  }

  @JsonProperty("apparent_temperature_celsius")
  public void setApparentTemperatureCelsius(List<Double> apparentTemperatureCelsius) {
    this.apparentTemperatureCelsius = apparentTemperatureCelsius;
  }

  @JsonProperty("temperature_80m_celsius")
  public List<Double> getTemperature80mCelsius() {
    return temperature80mCelsius;
  }

  @JsonProperty("temperature_80m_celsius")
  public void setTemperature80mCelsius(List<Double> temperature80mCelsius) {
    this.temperature80mCelsius = temperature80mCelsius;
  }

  @JsonProperty("temperature_120m_celsius")
  public List<Double> getTemperature120mCelsius() {
    return temperature120mCelsius;
  }

  @JsonProperty("temperature_120m_celsius")
  public void setTemperature120mCelsius(List<Double> temperature120mCelsius) {
    this.temperature120mCelsius = temperature120mCelsius;
  }

  @JsonProperty("soil_temperature_0cm_celsius")
  public List<Double> getSoilTemperature0cmCelsius() {
    return soilTemperature0cmCelsius;
  }

  @JsonProperty("soil_temperature_0cm_celsius")
  public void setSoilTemperature0cmCelsius(List<Double> soilTemperature0cmCelsius) {
    this.soilTemperature0cmCelsius = soilTemperature0cmCelsius;
  }

  @JsonProperty("soil_temperature_6cm_celsius")
  public List<Double> getSoilTemperature6cmCelsius() {
    return soilTemperature6cmCelsius;
  }

  @JsonProperty("soil_temperature_6cm_celsius")
  public void setSoilTemperature6cmCelsius(List<Double> soilTemperature6cmCelsius) {
    this.soilTemperature6cmCelsius = soilTemperature6cmCelsius;
  }

  @JsonProperty("rain_mm")
  public List<Double> getRainMm() {
    return rainMm;
  }

  @JsonProperty("rain_mm")
  public void setRainMm(List<Double> rainMm) {
    this.rainMm = rainMm;
  }

  @JsonProperty("showers_mm")
  public List<Double> getShowersMm() {
    return showersMm;
  }

  @JsonProperty("showers_mm")
  public void setShowersMm(List<Double> showersMm) {
    this.showersMm = showersMm;
  }

  @JsonProperty("snowfall_mm")
  public List<Double> getSnowfallMm() {
    return snowfallMm;
  }

  @JsonProperty("snowfall_mm")
  public void setSnowfallMm(List<Double> snowfallMm) {
    this.snowfallMm = snowfallMm;
  }

  @JsonProperty("daylight_hours")
  public List<Integer> getDaylightHours() {
    return daylightHours;
  }

  @JsonProperty("daylight_hours")
  public void setDaylightHours(List<Integer> daylightHours) {
    this.daylightHours = daylightHours;
  }

  @JsonProperty("sunset_iso")
  public List<Date> getSunsetIso() {
    return sunsetIso;
  }

  @JsonProperty("sunset_iso")
  public void setSunsetIso(List<Date> sunsetIso) {
    this.sunsetIso = sunsetIso;
  }

  @JsonProperty("sunrise_iso")
  public List<Date> getSunriseIso() {
    return sunriseIso;
  }

  @JsonProperty("sunrise_iso")
  public void setSunriseIso(List<Date> sunriseIso) {
    this.sunriseIso = sunriseIso;
  }
}
