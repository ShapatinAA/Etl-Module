package org.ashapatin.etl.model;

import java.util.LinkedHashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
    "time",
    "temperature_2m",
    "relative_humidity_2m",
    "dew_point_2m",
    "apparent_temperature",
    "temperature_80m",
    "temperature_120m",
    "wind_speed_10m",
    "wind_speed_80m",
    "wind_direction_10m",
    "wind_direction_80m",
    "visibility",
    "evapotranspiration",
    "weather_code",
    "soil_temperature_0cm",
    "soil_temperature_6cm",
    "rain",
    "showers",
    "snowfall"
})
public class HourlyUnits {

  @JsonProperty("time")
  private String time;
  @JsonProperty("temperature_2m")
  private String temperature2m;
  @JsonProperty("relative_humidity_2m")
  private String relativeHumidity2m;
  @JsonProperty("dew_point_2m")
  private String dewPoint2m;
  @JsonProperty("apparent_temperature")
  private String apparentTemperature;
  @JsonProperty("temperature_80m")
  private String temperature80m;
  @JsonProperty("temperature_120m")
  private String temperature120m;
  @JsonProperty("wind_speed_10m")
  private String windSpeed10m;
  @JsonProperty("wind_speed_80m")
  private String windSpeed80m;
  @JsonProperty("wind_direction_10m")
  private String windDirection10m;
  @JsonProperty("wind_direction_80m")
  private String windDirection80m;
  @JsonProperty("visibility")
  private String visibility;
  @JsonProperty("evapotranspiration")
  private String evapotranspiration;
  @JsonProperty("weather_code")
  private String weatherCode;
  @JsonProperty("soil_temperature_0cm")
  private String soilTemperature0cm;
  @JsonProperty("soil_temperature_6cm")
  private String soilTemperature6cm;
  @JsonProperty("rain")
  private String rain;
  @JsonProperty("showers")
  private String showers;
  @JsonProperty("snowfall")
  private String snowfall;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  @JsonProperty("time")
  public String getTime() {
    return time;
  }

  @JsonProperty("time")
  public void setTime(String time) {
    this.time = time;
  }

  @JsonProperty("temperature_2m")
  public String getTemperature2m() {
    return temperature2m;
  }

  @JsonProperty("temperature_2m")
  public void setTemperature2m(String temperature2m) {
    this.temperature2m = temperature2m;
  }

  @JsonProperty("relative_humidity_2m")
  public String getRelativeHumidity2m() {
    return relativeHumidity2m;
  }

  @JsonProperty("relative_humidity_2m")
  public void setRelativeHumidity2m(String relativeHumidity2m) {
    this.relativeHumidity2m = relativeHumidity2m;
  }

  @JsonProperty("dew_point_2m")
  public String getDewPoint2m() {
    return dewPoint2m;
  }

  @JsonProperty("dew_point_2m")
  public void setDewPoint2m(String dewPoint2m) {
    this.dewPoint2m = dewPoint2m;
  }

  @JsonProperty("apparent_temperature")
  public String getApparentTemperature() {
    return apparentTemperature;
  }

  @JsonProperty("apparent_temperature")
  public void setApparentTemperature(String apparentTemperature) {
    this.apparentTemperature = apparentTemperature;
  }

  @JsonProperty("temperature_80m")
  public String getTemperature80m() {
    return temperature80m;
  }

  @JsonProperty("temperature_80m")
  public void setTemperature80m(String temperature80m) {
    this.temperature80m = temperature80m;
  }

  @JsonProperty("temperature_120m")
  public String getTemperature120m() {
    return temperature120m;
  }

  @JsonProperty("temperature_120m")
  public void setTemperature120m(String temperature120m) {
    this.temperature120m = temperature120m;
  }

  @JsonProperty("wind_speed_10m")
  public String getWindSpeed10m() {
    return windSpeed10m;
  }

  @JsonProperty("wind_speed_10m")
  public void setWindSpeed10m(String windSpeed10m) {
    this.windSpeed10m = windSpeed10m;
  }

  @JsonProperty("wind_speed_80m")
  public String getWindSpeed80m() {
    return windSpeed80m;
  }

  @JsonProperty("wind_speed_80m")
  public void setWindSpeed80m(String windSpeed80m) {
    this.windSpeed80m = windSpeed80m;
  }

  @JsonProperty("wind_direction_10m")
  public String getWindDirection10m() {
    return windDirection10m;
  }

  @JsonProperty("wind_direction_10m")
  public void setWindDirection10m(String windDirection10m) {
    this.windDirection10m = windDirection10m;
  }

  @JsonProperty("wind_direction_80m")
  public String getWindDirection80m() {
    return windDirection80m;
  }

  @JsonProperty("wind_direction_80m")
  public void setWindDirection80m(String windDirection80m) {
    this.windDirection80m = windDirection80m;
  }

  @JsonProperty("visibility")
  public String getVisibility() {
    return visibility;
  }

  @JsonProperty("visibility")
  public void setVisibility(String visibility) {
    this.visibility = visibility;
  }

  @JsonProperty("evapotranspiration")
  public String getEvapotranspiration() {
    return evapotranspiration;
  }

  @JsonProperty("evapotranspiration")
  public void setEvapotranspiration(String evapotranspiration) {
    this.evapotranspiration = evapotranspiration;
  }

  @JsonProperty("weather_code")
  public String getWeatherCode() {
    return weatherCode;
  }

  @JsonProperty("weather_code")
  public void setWeatherCode(String weatherCode) {
    this.weatherCode = weatherCode;
  }

  @JsonProperty("soil_temperature_0cm")
  public String getSoilTemperature0cm() {
    return soilTemperature0cm;
  }

  @JsonProperty("soil_temperature_0cm")
  public void setSoilTemperature0cm(String soilTemperature0cm) {
    this.soilTemperature0cm = soilTemperature0cm;
  }

  @JsonProperty("soil_temperature_6cm")
  public String getSoilTemperature6cm() {
    return soilTemperature6cm;
  }

  @JsonProperty("soil_temperature_6cm")
  public void setSoilTemperature6cm(String soilTemperature6cm) {
    this.soilTemperature6cm = soilTemperature6cm;
  }

  @JsonProperty("rain")
  public String getRain() {
    return rain;
  }

  @JsonProperty("rain")
  public void setRain(String rain) {
    this.rain = rain;
  }

  @JsonProperty("showers")
  public String getShowers() {
    return showers;
  }

  @JsonProperty("showers")
  public void setShowers(String showers) {
    this.showers = showers;
  }

  @JsonProperty("snowfall")
  public String getSnowfall() {
    return snowfall;
  }

  @JsonProperty("snowfall")
  public void setSnowfall(String snowfall) {
    this.snowfall = snowfall;
  }

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }

}

