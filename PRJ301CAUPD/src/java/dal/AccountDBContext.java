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

    public Account checkAccountExist(String user) {
        String sql = "select * from account\n"
                + "where [user] = ?\n";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void singup(String user, String pass) {
        String sql = "insert into account\n"
                + "values(?,?,0,0)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, user);
            ResultSet rs = stm.executeQuery();
            stm.setString(1, user);
            stm.setString(2, pass);
            stm.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ArrayList<Account> getAllAccount() {
        ArrayList<Account> account = new ArrayList<>();

        try {
            String sql = "SELECT [uID]\n"
                    + "      ,[user]\n"
                    + "      ,[pass]\n"
                    + "      ,[isSell]\n"
                    + "      ,[isAdmin]\n"
                    + "  FROM [dbo].[Account]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                int uid = rs.getInt("uid");
                String user = rs.getString("user");
                String pass = rs.getString("pass");
                int isAdmin = rs.getInt("isAdmin");
                int isSell = rs.getInt("isSell");

                a.setUid(uid);
                a.setUser(user);
                a.setPass(pass);
                a.setIsAdmin(isAdmin);
                a.setIsSell(isSell);

                account.add(a);
            }
        } catch (Exception e) {

        }
        return account;

    }

    public void inserta(String user, String pass, int isell, int isadmin) {
        try {
            String sql = "INSERT INTO [dbo].[Account]\n"
                    + "           ([user]\n"
                    + "           ,[pass]\n"
                    + "           ,[isSell]\n"
                    + "           ,[isAdmin])\n"
                    + "     VALUES\n"
                    + "           (?,?,?,?)";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setString(1, user);
            stm.setString(2, pass);
            stm.setInt(3, isell);
            stm.setInt(4, isadmin);

            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete(int uid) {
        try {
            String sql = "DELETE FROM [dbo].[Account]\n"
                    + "      WHERE [uid] = ?";

            PreparedStatement stm = connection.prepareStatement(sql);

            stm.setInt(1, uid);
            stm.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ProductsDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public static void main(String[] args) {
//        Account account = new Account();
//        AccountDBContext adb = new AccountDBContext();
//        account = adb.login("vu", "123");
//        System.out.println(account.toString());
//    }
//    
//    public static void main(String[] args) {
//        AccountDBContext adb = new AccountDBContext();
//        adb.delete(8);
//    }
    public static void main(String[] args) {
        AccountDBContext adb = new AccountDBContext();
        adb.inserta("khang", "123", 0, 0);
    }
}
