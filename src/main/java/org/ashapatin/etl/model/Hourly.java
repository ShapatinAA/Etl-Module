package org.ashapatin.etl.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
public class Hourly {

  @JsonProperty("time")
  private List<Integer> time;
  @JsonProperty("temperature_2m")
  private List<Double> temperature2m;
  @JsonProperty("relative_humidity_2m")
  private List<Integer> relativeHumidity2m;
  @JsonProperty("dew_point_2m")
  private List<Double> dewPoint2m;
  @JsonProperty("apparent_temperature")
  private List<Double> apparentTemperature;
  @JsonProperty("temperature_80m")
  private List<Double> temperature80m;
  @JsonProperty("temperature_120m")
  private List<Double> temperature120m;
  @JsonProperty("wind_speed_10m")
  private List<Double> windSpeed10m;
  @JsonProperty("wind_speed_80m")
  private List<Double> windSpeed80m;
  @JsonProperty("wind_direction_10m")
  private List<Integer> windDirection10m;
  @JsonProperty("wind_direction_80m")
  private List<Integer> windDirection80m;
  @JsonProperty("visibility")
  private List<Double> visibility;
  @JsonProperty("evapotranspiration")
  private List<Double> evapotranspiration;
  @JsonProperty("weather_code")
  private List<Integer> weatherCode;
  @JsonProperty("soil_temperature_0cm")
  private List<Double> soilTemperature0cm;
  @JsonProperty("soil_temperature_6cm")
  private List<Double> soilTemperature6cm;
  @JsonProperty("rain")
  private List<Double> rain;
  @JsonProperty("showers")
  private List<Double> showers;
  @JsonProperty("snowfall")
  private List<Double> snowfall;
  @JsonIgnore
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  @JsonProperty("time")
  public List<Integer> getTime() {
    return time;
  }

  @JsonProperty("time")
  public void setTime(List<Integer> time) {
    this.time = time;
  }

  @JsonProperty("temperature_2m")
  public List<Double> getTemperature2m() {
    return temperature2m;
  }

  @JsonProperty("temperature_2m")
  public void setTemperature2m(List<Double> temperature2m) {
    this.temperature2m = temperature2m;
  }

  @JsonProperty("relative_humidity_2m")
  public List<Integer> getRelativeHumidity2m() {
    return relativeHumidity2m;
  }

  @JsonProperty("relative_humidity_2m")
  public void setRelativeHumidity2m(List<Integer> relativeHumidity2m) {
    this.relativeHumidity2m = relativeHumidity2m;
  }

  @JsonProperty("dew_point_2m")
  public List<Double> getDewPoint2m() {
    return dewPoint2m;
  }

  @JsonProperty("dew_point_2m")
  public void setDewPoint2m(List<Double> dewPoint2m) {
    this.dewPoint2m = dewPoint2m;
  }

  @JsonProperty("apparent_temperature")
  public List<Double> getApparentTemperature() {
    return apparentTemperature;
  }

  @JsonProperty("apparent_temperature")
  public void setApparentTemperature(List<Double> apparentTemperature) {
    this.apparentTemperature = apparentTemperature;
  }

  @JsonProperty("temperature_80m")
  public List<Double> getTemperature80m() {
    return temperature80m;
  }

  @JsonProperty("temperature_80m")
  public void setTemperature80m(List<Double> temperature80m) {
    this.temperature80m = temperature80m;
  }

  @JsonProperty("temperature_120m")
  public List<Double> getTemperature120m() {
    return temperature120m;
  }

  @JsonProperty("temperature_120m")
  public void setTemperature120m(List<Double> temperature120m) {
    this.temperature120m = temperature120m;
  }

  @JsonProperty("wind_speed_10m")
  public List<Double> getWindSpeed10m() {
    return windSpeed10m;
  }

  @JsonProperty("wind_speed_10m")
  public void setWindSpeed10m(List<Double> windSpeed10m) {
    this.windSpeed10m = windSpeed10m;
  }

  @JsonProperty("wind_speed_80m")
  public List<Double> getWindSpeed80m() {
    return windSpeed80m;
  }

  @JsonProperty("wind_speed_80m")
  public void setWindSpeed80m(List<Double> windSpeed80m) {
    this.windSpeed80m = windSpeed80m;
  }

  @JsonProperty("wind_direction_10m")
  public List<Integer> getWindDirection10m() {
    return windDirection10m;
  }

  @JsonProperty("wind_direction_10m")
  public void setWindDirection10m(List<Integer> windDirection10m) {
    this.windDirection10m = windDirection10m;
  }

  @JsonProperty("wind_direction_80m")
  public List<Integer> getWindDirection80m() {
    return windDirection80m;
  }

  @JsonProperty("wind_direction_80m")
  public void setWindDirection80m(List<Integer> windDirection80m) {
    this.windDirection80m = windDirection80m;
  }

  @JsonProperty("visibility")
  public List<Double> getVisibility() {
    return visibility;
  }

  @JsonProperty("visibility")
  public void setVisibility(List<Double> visibility) {
    this.visibility = visibility;
  }

  @JsonProperty("evapotranspiration")
  public List<Double> getEvapotranspiration() {
    return evapotranspiration;
  }

  @JsonProperty("evapotranspiration")
  public void setEvapotranspiration(List<Double> evapotranspiration) {
    this.evapotranspiration = evapotranspiration;
  }

  @JsonProperty("weather_code")
  public List<Integer> getWeatherCode() {
    return weatherCode;
  }

  @JsonProperty("weather_code")
  public void setWeatherCode(List<Integer> weatherCode) {
    this.weatherCode = weatherCode;
  }

  @JsonProperty("soil_temperature_0cm")
  public List<Double> getSoilTemperature0cm() {
    return soilTemperature0cm;
  }

  @JsonProperty("soil_temperature_0cm")
  public void setSoilTemperature0cm(List<Double> soilTemperature0cm) {
    this.soilTemperature0cm = soilTemperature0cm;
  }

  @JsonProperty("soil_temperature_6cm")
  public List<Double> getSoilTemperature6cm() {
    return soilTemperature6cm;
  }

  @JsonProperty("soil_temperature_6cm")
  public void setSoilTemperature6cm(List<Double> soilTemperature6cm) {
    this.soilTemperature6cm = soilTemperature6cm;
  }

  @JsonProperty("rain")
  public List<Double> getRain() {
    return rain;
  }

  @JsonProperty("rain")
  public void setRain(List<Double> rain) {
    this.rain = rain;
  }

  @JsonProperty("showers")
  public List<Double> getShowers() {
    return showers;
  }

  @JsonProperty("showers")
  public void setShowers(List<Double> showers) {
    this.showers = showers;
  }

  @JsonProperty("snowfall")
  public List<Double> getSnowfall() {
    return snowfall;
  }

  @JsonProperty("snowfall")
  public void setSnowfall(List<Double> snowfall) {
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
