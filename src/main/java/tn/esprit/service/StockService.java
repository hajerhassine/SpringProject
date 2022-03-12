package tn.esprit.service;

import java.util.List;

import tn.esprit.entities.Stock;

public interface StockService {
	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock u);

	Stock retrieveStock(Long id);
	//Stock retrieveStock(Long id , Stock u);
	void deleteStock(Long id);
}
