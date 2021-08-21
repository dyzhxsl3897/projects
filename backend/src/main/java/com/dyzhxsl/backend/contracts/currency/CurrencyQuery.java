package com.dyzhxsl.backend.contracts.currency;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CurrencyQuery implements Serializable {

	private static final long serialVersionUID = -6672687208512536546L;

	private static final String defaultCurrency = "USD";

	private boolean success;
	private String terms;
	private String privacy;
	private long timestamp;
	private Date date;
	private String source;
	private Map<String, Double> quotes;

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		this.date = new Date(this.timestamp * 1000);
	}

	public double getCurrency(String currencyCode) {
		if (currencyCode == defaultCurrency) {
			return 1;
		}

		String key = String.format("%s%s", defaultCurrency, currencyCode);
		if (!quotes.containsKey(key)) {
			return 1;
		}
		return quotes.get(key);
	}

}
