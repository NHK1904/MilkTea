/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author khang
 */
public class Account {

    String id, user, pass;

    public Account() {
        connect();
    }

    public Account(String id, String user, String pass) {
        this.id = id; 
        this.user = user;
        this.pass = pass;
        connect();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    Connection cnn;//kết nối DB
    Statement stm;//Thực thi câu lệnh
    PreparedStatement pstm;//Thuc thi SQL
    ResultSet rs;//Lưu trữ và sử lý dữ liệu

    private void connect() {
        try {
            cnn = (new DBContext().connection);
            if (cnn != null) {
                System.out.println("Connect successfully");
            } else {
                System.out.println("Connect Fail");
            }
        } catch (Exception e) {

        }
    }

    public Account checkAccount(String user, String pass) {
        try {
            String strSelect = "select * from Account "
                    + "where [user]=? "
                    + "and pass=?";
            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, user);
            pstm.setString(2, pass);
            rs = pstm.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3));
            }
        } catch (Exception e) {
            
        }
        return null;

    }

    public void changePass(String pass,String user) {
        try {
            String strDelete = "update Account set pass= ? where [user] = ?";

            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, pass);
            pstm.setString(2, user);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("changePass:" + e.getMessage());
        }
    }
}
