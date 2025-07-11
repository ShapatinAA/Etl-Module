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
    "sunrise",
    "sunset",
    "daylight_duration"
})
public class DailyUnits {

  @JsonProperty("time")
  private String time;
  @JsonProperty("sunrise")
  private String sunrise;
  @JsonProperty("sunset")
  private String sunset;
  @JsonProperty("daylight_duration")
  private String daylightDuration;
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

  @JsonProperty("sunrise")
  public String getSunrise() {
    return sunrise;
  }

  @JsonProperty("sunrise")
  public void setSunrise(String sunrise) {
    this.sunrise = sunrise;
  }

  @JsonProperty("sunset")
  public String getSunset() {
    return sunset;
  }

  @JsonProperty("sunset")
  public void setSunset(String sunset) {
    this.sunset = sunset;
  }

  @JsonProperty("daylight_duration")
  public String getDaylightDuration() {
    return daylightDuration;
  }

  @JsonProperty("daylight_duration")
  public void setDaylightDuration(String daylightDuration) {
    this.daylightDuration = daylightDuration;
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