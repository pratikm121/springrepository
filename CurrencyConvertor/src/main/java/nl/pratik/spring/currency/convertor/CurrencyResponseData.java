package nl.pratik.spring.currency.convertor;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyResponseData {
	
	@JsonProperty("success")
	private boolean success;
	@JsonProperty("timestamp")
	private Timestamp timestamp;
	@JsonProperty("base")
	private String base;
	@JsonProperty("date")
	private Date date;
	@JsonProperty("rates")
	private RatesData rates;
	//private String[] rates;
	
	
	@Override
	public String toString() {
		return "CurrencyResponseData [success=" + success + ", timestamp=" + timestamp + ", base=" + base + ", date="
				+ date + ", rates=" + rates + "]";
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Timestamp getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public RatesData getRates() {
		return rates;
	}
	public void setRates(RatesData rates) {
		this.rates = rates;
	}
	

}
