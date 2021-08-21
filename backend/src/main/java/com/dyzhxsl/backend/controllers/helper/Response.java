package com.dyzhxsl.backend.controllers.helper;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

public class Response {

	public static <T> ResponseEntity<T> ok(T body) {
		return response(body, null, HttpStatus.OK);
	}

	private static <T> ResponseEntity<T> response(T body, MultiValueMap<String, String> headers,
			HttpStatus httpStatus) {
		MultiValueMap<String, String> finalHeaders = headers == null ? new HttpHeaders() : new HttpHeaders(headers);
		finalHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "*");
		return new ResponseEntity<T>(body, finalHeaders, httpStatus);
	}

}
