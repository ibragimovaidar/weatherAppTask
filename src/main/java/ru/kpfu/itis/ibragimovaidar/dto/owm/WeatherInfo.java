package ru.kpfu.itis.ibragimovaidar.dto.owm;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherInfo {

	private String base;
	private String name;
	private Integer visibility;

	@JsonProperty("coord")
	private Coord coord;

	@JsonUnwrapped
	@JsonProperty("weather")
	private List<Weather> weather;

	@JsonProperty("main")
	private Main main;

	@JsonProperty("wind")
	private Wind wind;

	private SystemInfo systemInfo;
}
