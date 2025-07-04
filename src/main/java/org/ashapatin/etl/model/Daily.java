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
    "sunrise",
    "sunset",
    "daylight_duration"
})
public class Daily {

  @JsonProperty("time")
  private List<Integer> time;
  @JsonProperty("sunrise")
  private List<Integer> sunrise;
  @JsonProperty("sunset")
  private List<Integer> sunset;
  @JsonProperty("daylight_duration")
  private List<Double> daylightDuration;
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

  @JsonProperty("sunrise")
  public List<Integer> getSunrise() {
    return sunrise;
  }

  @JsonProperty("sunrise")
  public void setSunrise(List<Integer> sunrise) {
    this.sunrise = sunrise;
  }

  @JsonProperty("sunset")
  public List<Integer> getSunset() {
    return sunset;
  }

  @JsonProperty("sunset")
  public void setSunset(List<Integer> sunset) {
    this.sunset = sunset;
  }

  @JsonProperty("daylight_duration")
  public List<Double> getDaylightDuration() {
    return daylightDuration;
  }

  @JsonProperty("daylight_duration")
  public void setDaylightDuration(List<Double> daylightDuration) {
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