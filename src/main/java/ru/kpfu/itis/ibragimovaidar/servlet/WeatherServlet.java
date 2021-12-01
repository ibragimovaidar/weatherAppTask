package ru.kpfu.itis.ibragimovaidar.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.ibragimovaidar.dto.WeatherDto;
import ru.kpfu.itis.ibragimovaidar.service.WeatherService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@WebServlet(urlPatterns = "/weather")
public class WeatherServlet extends HttpServlet {

	private WeatherService weatherService;
	private ObjectMapper objectMapper;

	@Override
	public void init(ServletConfig config) {
		weatherService = (WeatherService) config.getServletContext().getAttribute(WeatherService.class.getName());
		objectMapper = (ObjectMapper) config.getServletContext().getAttribute(ObjectMapper.class.getName());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String query = request.getParameter("query");
		Optional<WeatherDto> weatherDto = weatherService.requestWeatherInfo(query);
		if (!weatherDto.isPresent()){
			response.sendError(400);
			return;
		}

		response.setCharacterEncoding(StandardCharsets.UTF_8.name());
		response.setContentType("application/json");
		try (PrintWriter printWriter = response.getWriter()){
			printWriter.write(objectMapper.writeValueAsString(weatherDto.get()));
		}
	}
}
