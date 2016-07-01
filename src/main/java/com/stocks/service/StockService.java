package com.stocks.service;

import java.util.List;

import com.querydsl.core.types.Predicate;
import com.stocks.model.Stock;
import com.stocks.model.StockDTO;

public interface StockService {
	public List<Stock> get(String search);

	List<Stock> getByName(String name);

	List<Stock> get(Predicate predicate);

	public Stock get(Long id);

	public Stock create(StockDTO stock);

	public Stock update(Long id, StockDTO stock);

	public Stock delete(Long id);
}
