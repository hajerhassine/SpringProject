package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.entities.Stock;
import tn.esprit.service.StockService;


@CrossOrigin(origins="http://localhost:4200")
@RestController
public class StockRestController {

	@Autowired
	StockService StockService ;
	//http://localhost:8081/SpringMVC/servlet/getAllStock
	@GetMapping("/getAllStock")
	public List<Stock> getStocks(){
	List<Stock> listStock = StockService.retrieveAllStocks();
	return listStock;
	}
	//http://localhost:8081/SpringMVC/servlet/retrieveStock/1
	 @GetMapping("/retrieveStock/{id_Stock}")
	public Stock retrieveStock(@PathVariable("id_Stock") long StockId) {
	return StockService.retrieveStock(StockId);
	}
	 

	//http://localhost:8081/SpringMVC/servlet/addStock
	 @PostMapping("/addStock")
	 @ResponseBody
	 public Stock addStock(@RequestBody Stock c)
	 {
	 Stock stock = StockService.addStock(c);
	 return stock;
	 }
	 
	//http://localhost:8081/SpringMVC/servlet/removestock/{id_Stock}
	 @DeleteMapping("/removestock/{id_Stock}")
	 public void removeStock(@PathVariable("id_Stock") long StockId) {
	 StockService.deleteStock(StockId);
	 }
	//http://localhost:8081/SpringMVC/servlet/modifystock
	 @PutMapping("/modifystock")
	 @ResponseBody
	 public Stock modifyStock(@RequestBody Stock stock) {
	 return StockService.updateStock(stock);
	 }
	 
}
