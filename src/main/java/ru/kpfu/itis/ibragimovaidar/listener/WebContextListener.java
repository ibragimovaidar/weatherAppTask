package ru.kpfu.itis.ibragimovaidar.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.kpfu.itis.ibragimovaidar.config.Config;
import ru.kpfu.itis.ibragimovaidar.service.WeatherService;
import ru.kpfu.itis.ibragimovaidar.service.impl.WeatherServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static ru.kpfu.itis.ibragimovaidar.config.Config.getAsyncHttpClient;
import static ru.kpfu.itis.ibragimovaidar.config.Config.getObjectMapper;

@WebListener
public class WebContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext servletContext = sce.getServletContext();

		WeatherService weatherService = new WeatherServiceImpl(getAsyncHttpClient(), getObjectMapper());
		servletContext.setAttribute(WeatherService.class.getName(), weatherService);
		servletContext.setAttribute(ObjectMapper.class.getName(), getObjectMapper());
	}
}
