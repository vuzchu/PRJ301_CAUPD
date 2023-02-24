/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.stores;

/**
 *
 * @author vu
 */
public class StoreDBContext extends DBContext {
    
    public ArrayList<stores> getAllStores() {
        ArrayList<stores> stores = new ArrayList<>();
        
        try {
            String sql = "SELECT [store_id]\n"
                    + "      ,[store_name]\n"
                    + "      ,[phone]\n"
                    + "      ,[email]\n"
                    + "      ,[street]\n"
                    + "      ,[city]\n"
                    + "  FROM [dbo].[stores]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                stores s1 = new stores();
                
                int store_id = rs.getInt("store_id");
                String store_name = rs.getString("store_name");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String street = rs.getString("street");
                String city = rs.getString("city");
                
                s1.setStore_id(store_id);
                s1.setStore_name(store_name);
                s1.setPhone(phone);
                s1.setEmail(email);
                s1.setStreet(street);
                s1.setCity(city);
                
                stores.add(s1);
            }
        } catch (Exception e) {
            
        }
        return stores;
        
    }
}
