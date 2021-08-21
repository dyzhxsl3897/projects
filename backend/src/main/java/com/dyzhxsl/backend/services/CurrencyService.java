package com.dyzhxsl.backend.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dyzhxsl.backend.contracts.currency.CurrencyQuery;
import com.dyzhxsl.backend.dao.entities.CurrencyHistory;
import com.dyzhxsl.backend.dao.repos.CurrencyHistoryRepository;
import com.dyzhxsl.backend.restclient.ApiProvider;

@Service
public class CurrencyService {

	@Value("${currencylayer.api.url.query}")
	private String queryUrl;
	@Value("${currencylayer.api.access.key}")
	private String accessKey;
	@Value("${currencylayer.currencies}")
	private String currencies;
	@Value("${currencylayer.source}")
	private String source;

	@Autowired
	private ApiProvider api;

	@Autowired
	private CurrencyHistoryRepository currencyHistoryRepository;

	public CurrencyQuery query() {
		return api.Get(queryUrl, CurrencyQuery.class, accessKey, currencies, source);
	}

	@Transactional
	public List<CurrencyHistory> getAll() {
		List<CurrencyHistory> currencyHistoryList = new ArrayList<>();
		currencyHistoryRepository.findAll().forEach(currencyHistoryList::add);
		return currencyHistoryList;
	}

	@Transactional
	public void save(CurrencyQuery query) {
		CurrencyHistory history = CurrencyHistory.builder().date(query.getDate()).usd(1).cad(query.getCurrency("CAD"))
				.cny(query.getCurrency("CNY")).build();
		currencyHistoryRepository.save(history);
	}

}
