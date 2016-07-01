package com.stocks.repository;

import java.util.List;

import com.stocks.model.Stock;

public interface StockRepositoryCustom {
	public List<Stock> find(String search);
}
