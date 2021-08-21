package com.dyzhxsl.backend.restclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiProvider {

	@Autowired
	public RestTemplate api;

	public <TResult> TResult Get(String url, Class<TResult> clazz, Object... parameters) {
		return api.getForObject(url, clazz, parameters);
	}

}
