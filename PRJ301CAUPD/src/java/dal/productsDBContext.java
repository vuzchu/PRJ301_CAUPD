/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.category;
import model.products;

/**
 *
 * @author vu
 */
public class ProductsDBContext extends DBContext {

    public ArrayList<products> list() {
        ArrayList<products> products = new ArrayList<>();

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
                products s = new products();
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

    public ArrayList<products> getAllProductByCID(int cid) {
        ArrayList<products> products = new ArrayList<>();

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
                products s = new products();
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
