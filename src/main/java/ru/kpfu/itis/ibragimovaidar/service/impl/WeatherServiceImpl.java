package ru.kpfu.itis.ibragimovaidar.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Request;
import org.asynchttpclient.RequestBuilder;
import org.asynchttpclient.Response;
import org.asynchttpclient.util.HttpConstants;
import ru.kpfu.itis.ibragimovaidar.dto.WeatherDto;
import ru.kpfu.itis.ibragimovaidar.dto.owm.WeatherInfo;
import ru.kpfu.itis.ibragimovaidar.service.WeatherService;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

import static ru.kpfu.itis.ibragimovaidar.util.PropertiesUtil.getProperty;

@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

	private final AsyncHttpClient asyncHttpClient;
	private final ObjectMapper objectMapper;

	private static final String OWM_API_KEY = getProperty("owm.api.key");

	@Override
	public Optional<WeatherDto> requestWeatherInfo(String query) {
		Request request = new RequestBuilder(HttpConstants.Methods.GET)
				.setUrl("http://api.openweathermap.org/data/2.5/weather")
				.addQueryParam("appid", OWM_API_KEY)
				.addQueryParam("q", query)
				.addQueryParam("lang", "ru")
				.build();

		Response response = null;
		try {
			response = asyncHttpClient.executeRequest(request).get();
		} catch (InterruptedException | ExecutionException e) {
			throw new RuntimeException("Request error", e);
		}
		try {
			WeatherInfo weatherInfo = objectMapper.readValue(response.getResponseBody(), WeatherInfo.class);
			return Optional.ofNullable(WeatherDto.from(weatherInfo));
		} catch (JsonProcessingException e) {
			throw new RuntimeException("Request body parsing error", e);
		}
	}
}
