package com.ams.grocerylistwebservice.repository;

import com.ams.grocerylistwebservice.entity.GroceryItem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroceryItemRepository extends CrudRepository<GroceryItem, Long> {
    GroceryItem findById(String id);
}
