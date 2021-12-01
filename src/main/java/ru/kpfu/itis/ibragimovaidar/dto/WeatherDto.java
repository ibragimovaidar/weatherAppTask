package ru.kpfu.itis.ibragimovaidar.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kpfu.itis.ibragimovaidar.dto.owm.WeatherInfo;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WeatherDto {

	private String name;
	private String weatherDesc;
	private Integer windDegrees;
	private Float windSpeed;

	private Float temp;
	private Float tempFeelsLike;
	private Integer pressure;
	private Integer humidity;

	public static WeatherDto from(WeatherInfo weatherInfo){
		return WeatherDto.builder()
				.name(weatherInfo.getName())
				.weatherDesc(weatherInfo.getWeather().get(0).getDescription())
				.temp((weatherInfo.getMain().getTemp() - 32) * (float) 5/9 )
				.tempFeelsLike(weatherInfo.getMain().getFeelsLike())
				.pressure(weatherInfo.getMain().getPressure())
				.humidity(weatherInfo.getMain().getHumidity())
				.build();
	}
}
