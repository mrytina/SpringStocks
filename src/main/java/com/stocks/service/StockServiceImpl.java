package com.stocks.service;

import java.util.List;

import javax.inject.Inject;

import org.dozer.Mapper;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;
import com.stocks.model.Stock;
import com.stocks.model.StockDTO;
import com.stocks.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	@Inject
	private StockRepository stockRepository;
	@Inject
	private Mapper mapper;

	@Override
	public List<Stock> get(String search) {
		return (List<Stock>) stockRepository.find(search);
	}

	@Override
	public Stock get(Long id) {
		return stockRepository.findOne(id);
	}

	@Override
	public List<Stock> getByName(String name) {
		return stockRepository.findStockByName(name);
	}

	@Override
	public List<Stock> get(Predicate predicate) {
		return (List<Stock>) stockRepository.findAll(predicate);
	}

	@Override
	public Stock create(StockDTO stock) {
		stock.setId(null);
		Stock model = mapper.map(stock, Stock.class);
		return stockRepository.save(model);
	}

	@Override
	public Stock update(Long id, StockDTO stock) {
		Stock model = get(id);
		stock.setId(id);
		mapper.map(stock, model);
		return stockRepository.save(model);
	}

	@Override
	public Stock delete(Long id) {
		Stock stock = get(id);
		if (stock != null) {
			stockRepository.delete(stock);
		}
		return stock;
	}
}
