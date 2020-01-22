package com.ams.grocerylistwebservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grocery_items")
public class GroceryItem {

    @Id
    private String id;
    private String name;
    private int amount;
    private boolean isDone;

    public GroceryItem() { }

    public GroceryItem(String id, String name, int amount, boolean isDone) {
        this.id = id;
        this.name = name;
        this.amount = amount;
        this.isDone = isDone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", isDone=" + isDone +
                '}';
    }
}
