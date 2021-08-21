package com.dyzhxsl.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dyzhxsl.backend.controllers.helper.Response;
import com.dyzhxsl.backend.dao.entities.CurrencyHistory;
import com.dyzhxsl.backend.services.CurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	@RequestMapping("/query/all")
	public ResponseEntity<List<CurrencyHistory>> queryAll() {
		return Response.ok(currencyService.getAll());
	}

}
