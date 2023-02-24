/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vu
 */
public class stores {

    private int store_id;
    private String store_name, phone, email, street, city;

    public stores() {
    }

    public stores(int store_id, String store_name, String phone, String email, String street, String city) {
        this.store_id = store_id;
        this.store_name = store_name;
        this.phone = phone;
        this.email = email;
        this.street = street;
        this.city = city;
    }

    public int getStore_id() {
        return store_id;
    }

    public void setStore_id(int store_id) {
        this.store_id = store_id;
    }

    public String getStore_name() {
        return store_name;
    }

    public void setStore_name(String store_name) {
        this.store_name = store_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "stores{" + "store_id=" + store_id + ", store_name=" + store_name + ", phone=" + phone + ", email=" + email + ", street=" + street + ", city=" + city + '}';
    }

}
