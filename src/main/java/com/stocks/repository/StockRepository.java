package com.stocks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.stereotype.Repository;

import com.stocks.model.QStock;
import com.stocks.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>, QueryDslPredicateExecutor<Stock>, QuerydslBinderCustomizer<QStock>, StockRepositoryCustom {
	public List<Stock> findStockByName(String name);

	@Override
	default public void customize(QuerydslBindings bindings, QStock stock) {
		bindings.bind(stock.market).first((path, value) -> path.in(value));
		bindings.bind(stock.status).first((path, value) -> path.in(value));
		bindings.excluding(stock.created);
		bindings.excluding(stock.updated);
	}
}
