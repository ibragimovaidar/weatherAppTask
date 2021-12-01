package ru.kpfu.itis.ibragimovaidar.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.asynchttpclient.AsyncHttpClient;
import org.asynchttpclient.Dsl;

public class Config {

	public static AsyncHttpClient getAsyncHttpClient(){
		return Dsl.asyncHttpClient();
	}

	public static ObjectMapper getObjectMapper(){
		return new ObjectMapper();
	}
}
