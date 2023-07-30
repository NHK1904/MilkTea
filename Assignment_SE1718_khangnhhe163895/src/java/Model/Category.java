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
import java.util.ArrayList;

/**
 *
 * @author khang
 */
public class Category {
    private int cid;
    private String cname;

    public Category() {
        connect();
    }

    public Category(int cid, String cname) {
        this.cid = cid;
        this.cname = cname;
        connect();
    }
    

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
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
     
     public ArrayList<Category> getListCategory() {
        ArrayList<Category> data = new ArrayList<Category>();
        try {
            String strSelect = "select * from Category ";

            stm = cnn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            rs = stm.executeQuery(strSelect);
            while (rs.next()) {
                int cid = rs.getInt(1);
                String cname = rs.getString(2);
               
                
                data.add(new Category(cid, cname));
            }
        } catch (Exception e) {
            System.out.println("getListCategory:" + e.getMessage());
        }
        return data;
    }
}
