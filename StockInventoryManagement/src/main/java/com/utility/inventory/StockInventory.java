package com.utility.inventory;

import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "STOCK_INVENTORY")
public class StockInventory {
	@Id
	@Field
	private ObjectId id;

	@Field
	@Indexed
	private int stockNumber;

	@Field
	private String stockName;

	@Field
	private double purchasingPrice;

	@Field
	private Date purchaseDate;

	@Field
	private long quantity;

	public int getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(int stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getStockName() {
		return stockName;
	}

	public void setStockName(String stockName) {
		this.stockName = stockName;
	}

	public double getPurchasingPrice() {
		return purchasingPrice;
	}

	public void setPurchasingPrice(double purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
