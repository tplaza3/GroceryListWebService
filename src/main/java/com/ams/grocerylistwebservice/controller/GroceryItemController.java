package com.ams.grocerylistwebservice.controller;

import com.ams.grocerylistwebservice.entity.GroceryItem;
import com.ams.grocerylistwebservice.repository.GroceryItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/grocery-list")
public class GroceryItemController {

    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GroceryItemController(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    @GetMapping(value = "/items", produces = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public List<GroceryItem> getGroceryItems() {
        return (List<GroceryItem>) groceryItemRepository.findAll();
    }

    @PostMapping(value = "/items", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public void addGroceryItem(@RequestBody GroceryItem requestBody) {
        groceryItemRepository.save(requestBody);
    }

    @PutMapping(value = "/items", consumes = MediaType.APPLICATION_JSON_VALUE)
    @CrossOrigin
    public void updateGroceryItem(@RequestBody GroceryItem requestBody) {
        // find item by id in repo
        GroceryItem item = groceryItemRepository.findById(requestBody.getId());
        System.out.println(item.toString());
        // update item with request body
        item.setAmount(requestBody.getAmount());
        item.setName(requestBody.getName());
        item.setDone(requestBody.isDone());
        //save item to repo
        groceryItemRepository.save(item);
    }

    @DeleteMapping("/items/{id}")
    @CrossOrigin
    public void deleteGroceryItem(@PathVariable String id) {
        groceryItemRepository.delete(groceryItemRepository.findById(id));
    }

}
