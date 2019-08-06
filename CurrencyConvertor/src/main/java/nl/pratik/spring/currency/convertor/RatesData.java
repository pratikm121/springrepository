package nl.pratik.spring.currency.convertor;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RatesData {
	
	@JsonProperty("INR")
	private double inr;
	@JsonProperty("USD")
	private double usd;
	@Override
	public String toString() {
		return "RatesData [inr=" + inr + ", usd=" + usd + "]";
	}
	public double getUsd() {
		return usd;
	}
	public void setUsd(double usd) {
		this.usd = usd;
	}
	public double getInr() {
		return inr;
	}
	public void setInr(double inr) {
		this.inr = inr;
	}

}
