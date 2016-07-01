package com.stocks.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQuery;
import com.stocks.model.Market;
import com.stocks.model.QStock;
import com.stocks.model.Status;
import com.stocks.model.Stock;

public class StockRepositoryImpl implements StockRepositoryCustom {
	@PersistenceContext
	protected EntityManager em;

	@Override
	public List<Stock> find(String search) {
		QStock stock = QStock.stock;
		List<Market> currentMarket = getMarket(search);
		List<Status> currentStatus = getStatus(search);

		JPAQuery<Stock> query = new JPAQuery(em);
		BooleanBuilder builder = new BooleanBuilder();
		builder.or(stock.id.like(search));
		builder.or(stock.symbol.containsIgnoreCase(search));
		builder.or(stock.name.containsIgnoreCase(search));
		builder.or(stock.currency.containsIgnoreCase(search));
		builder.or(stock.country.containsIgnoreCase(search));
		if (!currentMarket.isEmpty()) {
			builder.or(stock.market.in(currentMarket));
		}
		if (!currentStatus.isEmpty()) {
			builder.or(stock.status.in(currentStatus));
		}
		return query.from(stock).where(builder).fetch();
	}

	private List<Market> getMarket(String search) {
		List<Market> currentMarket = new ArrayList<>();
		for (Market market: Market.values()) {
			if (search.toLowerCase().contains(market.name().toLowerCase())) {
				currentMarket.add(market);
			}
		}
		return currentMarket;
	}

	private List<Status> getStatus(String search) {
		List<Status> currentStatus = new ArrayList<>();
		for (Status status: Status.values()) {
			if (search.toLowerCase().contains(status.name().toLowerCase())) {
				currentStatus.add(status);
			}
		}
		return currentStatus;
	}
}
