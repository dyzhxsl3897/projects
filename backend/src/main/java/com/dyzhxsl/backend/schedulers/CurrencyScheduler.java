package com.dyzhxsl.backend.schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.dyzhxsl.backend.contracts.currency.CurrencyQuery;
import com.dyzhxsl.backend.services.CurrencyService;

@Component
public class CurrencyScheduler {

	@Autowired
	private CurrencyService currencyService;

	@Scheduled(cron = "0 0 19 ? * *")
	public void printSystemTime() {
		CurrencyQuery query = currencyService.query();
		currencyService.save(query);
	}

}
