package com.metacube.training.model.commands;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PlanCommand {

	@NotNull
	private int rid;

	@NotNull
	private int price;

	@NotBlank
	private String rate;

	@NotBlank
	private String period;

	@NotBlank
	private String currency;

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

}
