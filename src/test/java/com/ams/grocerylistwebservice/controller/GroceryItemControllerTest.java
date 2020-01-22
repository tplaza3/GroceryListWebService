package com.ams.grocerylistwebservice.controller;

import com.ams.grocerylistwebservice.entity.GroceryItem;
import com.ams.grocerylistwebservice.repository.GroceryItemRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

@SpringBootTest
@AutoConfigureMockMvc
public class GroceryItemControllerTest {

    @Autowired
    private GroceryItemRepository groceryItemRepository;
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        GroceryItem item1 = new GroceryItem("1","toast", 1, false);
        GroceryItem item2 = new GroceryItem("2","orange", 2, false);
        groceryItemRepository.save(item1);
        groceryItemRepository.save(item2);
    }

    @Test
    public void shouldGetGroceryItems() throws Exception {
        ResultActions response = mockMvc.perform(get("http://localhost:8080/grocery-list/items"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldAddGroceryItem() throws Exception {
        GroceryItem item = new GroceryItem("3","bread", 1, false);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(item);

        ResultActions response = mockMvc.perform(post("http://localhost:8080/grocery-list/items")
                .contentType("application/json").content(requestJson));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }


    @Test
    public void shouldUpdateGroceryItems() throws Exception {
        GroceryItem updatedItem = new GroceryItem("1","toast update", 1, true);
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(updatedItem);

        ResultActions response = mockMvc.perform(put("http://localhost:8080/grocery-list/items")
                .contentType("application/json").content(requestJson));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void shouldDeleteGroceryItems() throws Exception {
        ResultActions response = mockMvc.perform(delete("http://localhost:8080/grocery-list/items/2"));

        response.andExpect(MockMvcResultMatchers.status().isOk());
    }
}
