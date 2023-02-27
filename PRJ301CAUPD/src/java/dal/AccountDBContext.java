/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Account;

/**
 *
 * @author vu
 */
public class AccountDBContext extends DBContext {

    public Account login(String user, String pass) {
        try {
            String sql = "SELECT [uID]\n"
                    + "      ,[user]\n"
                    + "      ,[pass]\n"
                    + "      ,[isSell]\n"
                    + "      ,[isAdmin]\n"
                    + "  FROM [dbo].[Account]\n"
                    + "  where [user] =? and pass=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            stm.setString(2, pass);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                int uid = rs.getInt("uid");
                int isAdmin = rs.getInt("isAdmin");
                int isSell = rs.getInt("isSell");

                a.setUid(uid);
                a.setUser(user);
                a.setPass(pass);
                a.setIsAdmin(isAdmin);
                a.setIsSell(isSell);
                return a;
            }
        } catch (Exception e) {

        }
        return null;
    }

    
    
    
    public static void main(String[] args) {
        Account account = new Account();
        AccountDBContext adb = new AccountDBContext();
        account = adb.login("vu", "123");
        System.out.println(account.toString());
    }
}
