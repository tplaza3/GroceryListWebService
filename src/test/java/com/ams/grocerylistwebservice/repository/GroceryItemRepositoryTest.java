package com.ams.grocerylistwebservice.repository;

import com.ams.grocerylistwebservice.entity.GroceryItem;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class GroceryItemRepositoryTest {

    @Autowired
    private GroceryItemRepository groceryItemRepository;

    @Test
    public void shouldFindGroceryItemById() {
        groceryItemRepository.save(new GroceryItem("46c236c9-c6ed-4b6b-a493-629280570a14", "toast", 1, false));
        GroceryItem groceryItem = groceryItemRepository.findById("46c236c9-c6ed-4b6b-a493-629280570a14");

        System.out.println(groceryItem.toString());
        assertThat(groceryItem.getName()).isEqualTo("toast");
    }

    @Test
    public void shouldFindAllGroceryItems() {
        groceryItemRepository.save(new GroceryItem("46c236c9-c6ed-4b6b-a493-629280570a14","toast", 1, false));
        groceryItemRepository.save(new GroceryItem("44c236c9-c6ed-4b6b-a493-629280570a14","bread", 2, true));
        Iterable<GroceryItem> groceryItems = groceryItemRepository.findAll();

        assertThat(groceryItems).hasSize(2);
    }
}
