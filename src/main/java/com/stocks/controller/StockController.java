package com.stocks.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.querydsl.core.types.Predicate;
import com.stocks.exception.ValidationException;
import com.stocks.model.Stock;
import com.stocks.model.StockDTO;
import com.stocks.service.StockService;

@RestController
@RequestMapping("/stocks")
public class StockController {
	@Inject
	StockService stockService;

	@RequestMapping(value = "{search}", method = RequestMethod.GET)
	public List<Stock> get(@PathVariable(value = "search") String search) {
		return stockService.get(search);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Object get(@QuerydslPredicate(root = Stock.class) Predicate predicate) {
		return stockService.get(predicate);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public Object save(@Valid @RequestBody StockDTO stock, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Validation Errror", bindingResult.getAllErrors());
		}
		return stockService.create(stock);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Object put(@PathVariable Long id, @Valid @RequestBody StockDTO stock, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			throw new ValidationException("Validation Errror", bindingResult.getAllErrors());
		}
		return stockService.update(id, stock);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public Object delete(@PathVariable Long id) {
		return stockService.delete(id);
	}
}
