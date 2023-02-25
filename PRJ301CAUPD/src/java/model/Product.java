/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.math.BigDecimal;
import java.sql.Date;

/**
 *
 * @author vu
 */
public class Product {

    private int product_id;
    private String product_name;
    private double price;
    private String description;
    private String image;
   

    public Product() {
    }

    public Product(int product_id, String product_name, double price, String description, String image) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.price = price;
        this.description = description;
        this.image = image;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "products{" + "product_id=" + product_id + ", product_name=" + product_name + ", price=" + price + ", description=" + description + ", image=" + image + '}';
    }

   

}