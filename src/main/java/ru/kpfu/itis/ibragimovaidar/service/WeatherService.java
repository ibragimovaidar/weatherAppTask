package ru.kpfu.itis.ibragimovaidar.service;

import ru.kpfu.itis.ibragimovaidar.dto.WeatherDto;
import ru.kpfu.itis.ibragimovaidar.dto.owm.WeatherInfo;

import java.util.Optional;

public interface WeatherService {

	Optional<WeatherDto> requestWeatherInfo(String query);
}
