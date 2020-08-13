package com.utility.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utility.inventory.StockInventory;
import com.utility.inventory.StockInventoryRepository;

@RestController
@RequestMapping("/api/v1")
public class StockInventoryController {

	@Autowired
	private StockInventoryRepository inventoryRepository;

	/**
	 * To get individual stock
	 * @param stockId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/stocks/{id}")
	public ResponseEntity<StockInventory> getStockById(@PathVariable(value = "id") String stockId) throws Exception {
		StockInventory stock = inventoryRepository.findById(stockId)
				.orElseThrow(() -> new Exception("No stock found" + stockId));
		return ResponseEntity.ok().body(stock);
	}

	/**
	 * get all stocks available
	 * @return
	 */
	@GetMapping("/stocks")
	public List<StockInventory> getAllStocks() {
		return inventoryRepository.findAll();
	}

	@PostMapping("/stocks")
	public StockInventory createStock(@RequestBody StockInventory stockInventory) {
		return inventoryRepository.save(stockInventory);
	}

	@PutMapping("/stocks/{id}")
	public ResponseEntity<StockInventory> updateStock(@PathVariable(value = "id") String stockId,
			@RequestBody StockInventory stockInventory) throws Exception {
		StockInventory inventory = inventoryRepository.findById(stockId)
				.orElseThrow(() -> new Exception("No stock found" + stockId));
		BeanUtils.copyProperties(stockInventory, inventory);
		final StockInventory updatedStock = inventoryRepository.save(inventory);
		return ResponseEntity.ok(updatedStock);
	}

}
