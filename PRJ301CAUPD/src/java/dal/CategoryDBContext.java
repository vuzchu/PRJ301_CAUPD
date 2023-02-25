/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.category;
import model.Product;

/**
 *
 * @author vu
 */
public class CategoryDBContext extends DBContext {

    public ArrayList<category> getAllCategory() {
        ArrayList<category> category = new ArrayList<>();

        try {
            String sql = "SELECT [cid]\n"
                    + "      ,[cname]\n"
                    + "  FROM [dbo].[category]";
            PreparedStatement stm = connection.prepareStatement(sql);
            
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                category c = new category();
                int cid = rs.getInt("cid");
                String cname = rs.getString("cname");

                c.setCid(cid);
                c.setCname(cname);

                category.add(c);
            }
        } catch (Exception e) {

        }
        return category;

    }
    
     
    
}
