package tn.esprit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.entities.Stock;
import tn.esprit.repository.Stockrepository;
@Service
public class StockServiceImpl implements StockService{
 @Autowired
 
 Stockrepository stockrepository ;
 //@Scheduled(cron = "*/60 * * * * *")
	@Override
	public List<Stock> retrieveAllStocks() {
		List <Stock> stocks = (List<Stock>) stockrepository.findAll();
		System.out.println("Method run");
		return stocks;
	}

	
	@Override
	public Stock addStock(Stock stock) {
		return stockrepository.save(stock);
	}

	@Override
	public Stock updateStock(Stock u) {
		Stock t = stockrepository.save(u);
		return t;
	}

	@Override
	public Stock retrieveStock(Long id) {
		Stock t = stockrepository.findById(id).get();
		return t;
		
	}


	@Override
	public void deleteStock(Long id) {
		stockrepository.deleteById(id);
		
	}
	

}
