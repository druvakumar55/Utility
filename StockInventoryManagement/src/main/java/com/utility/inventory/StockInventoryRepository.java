package com.utility.inventory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockInventoryRepository extends MongoRepository<StockInventory, String> {
}
