/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public Product getProductByProductID(int product__id) {

        try {
            String sql = "SELECT [product_name]\n"
                    + "      ,[product__id]\n"
                    + "      ,[price]\n"
                    + "      ,[description]\n"
                    + "      ,[image]\n"
                    + "      ,[cid]\n"
                    + "  FROM [dbo].[products]\n"
                    + "where [product__id]=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, product__id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Product s = new Product();

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
            String sql = "select * from [products] where sell_id =?";
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

    public void insert(String product_name, int price,
            String description, String image, int cid, int sell_id) {
        try {
            String sql = "INSERT INTO [dbo].[products]\n"
                    + "           ([product_name]\n"
                    + "           ,[price]\n"
                    + "           ,[description]\n"
                    + "           ,[image]\n"
                    + "           ,[cid]\n"
                    + "           ,[sell_id])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?,?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, product_name);
            stm.setInt(2, price);
            stm.setString(3, description);
            stm.setString(4, image);
            stm.setInt(5, cid);
            stm.setInt(6, sell_id);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int product__id) {
        try {
            String sql = "DELETE FROM [dbo].[products]\n"
                    + "      WHERE [product__id] = ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, product__id);
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        ProductsDBContext pdb = new ProductsDBContext();
//        pdb.insert("tron1", 200, "tron2", "tron3", 1, 0);
        pdb.delete(14);
    }
//    public static void main(String[] args) {
//         ProductsDBContext pdb = new ProductsDBContext();
//         ArrayList<Product> product = pdb.list();
//         for (Product product1 : product) {
//             System.out.println(product1.toString());
//        }
//    }

    public void edit(Product p) {
        try {
            String sql = "UPDATE [dbo].[products]\n"
                    + "   SET [product_name] = ?\n"
                    + "      ,[price] = ?\n"
                    + "      ,[description] = ? \n"
                    + "      ,[image] = ? \n"
                    + "      ,[cid] = ?\n"
                    + "      ,[sell_id] = ?\n"
                    + " WHERE product__id = ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, p.getProduct_name());
            stm.setDouble(2, p.getPrice());
            stm.setString(3, p.getImage());
            stm.setInt(4, p.getCid());
            stm.setInt(5, p.getSell_id());

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
