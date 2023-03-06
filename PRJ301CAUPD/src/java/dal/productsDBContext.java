/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Product;

/**
 *
 * @author vu
 */
public class ProductsDBContext extends DBContext {

    public ArrayList<Product> list() {
        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT [product__id]\n"
                    + "      ,[product_name]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[image]\n"
                    + "  FROM [dbo].[products]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                int product__id = rs.getInt("product__id");
                String product_name = rs.getString("product_name");
                Double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("image");

                s.setProduct_id(product__id);
                s.setProduct_name(product_name);
                s.setPrice(price);
                s.setDescription(description);
                s.setImage(image);

                products.add(s);
            }
        } catch (Exception e) {

        }
        return products;

    }

    public ArrayList<Product> getAllProductByCID(int cid) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT [product__id]\n"
                    + "      ,[product_name]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[image]\n"
                    + "  FROM [dbo].[products] where cid =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                int product__id = rs.getInt("product__id");
                String product_name = rs.getString("product_name");
                Double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("image");

                s.setProduct_id(product__id);
                s.setProduct_name(product_name);
                s.setPrice(price);
                s.setDescription(description);
                s.setImage(image);

                products.add(s);
            }
        } catch (Exception e) {

        }
        return products;

    }

    public Product getProductByProductID(int product_id) {

        try {
            String sql = "SELECT [product__id]\n"
                    + "      ,[product_name]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[image]\n"
                    + "      ,[cid]\n"
                    + "  FROM [dbo].[products]\n"
                    + "where [product__id]=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, product_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                int product__id = rs.getInt("product__id");
                String product_name = rs.getString("product_name");
                Double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("image");

                s.setProduct_id(product__id);
                s.setProduct_name(product_name);
                s.setPrice(price);
                s.setDescription(description);
                s.setImage(image);

                return s;
//                Product.add(s);
            }
        } catch (Exception e) {

        }
        return null;

    }

    public ArrayList<Product> searchAllProductByProductName(String product_name) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT [product__id]\n"
                    + "      ,[product_name]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[image]\n"
                    + "      ,[cid]\n"
                    + "  FROM [dbo].[products] where product_name like ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, product_name);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                int product__id = rs.getInt("product__id");
                String name = rs.getString("product_name");
                Double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("image");

                s.setProduct_id(product__id);
                s.setProduct_name(name);
                s.setPrice(price);
                s.setDescription(description);
                s.setImage(image);

                products.add(s);
            }
        } catch (Exception e) {

        }
        return products;

    }
    
     public ArrayList<Product> getAllProductBySellId(int sell_id) {
        ArrayList<Product> products = new ArrayList<>();

        try {
            String sql = "select * from Product where sell_id =?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, sell_id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();
                int product__id = rs.getInt("product__id");
                String product_name = rs.getString("product_name");
                Double price = rs.getDouble("price");
                String description = rs.getString("description");
                String image = rs.getString("image");

                s.setProduct_id(product__id);
                s.setProduct_name(product_name);
                s.setPrice(price);
                s.setDescription(description);
                s.setImage(image);

                products.add(s);
            }
        } catch (Exception e) {

        }
        return products;

    }

}
