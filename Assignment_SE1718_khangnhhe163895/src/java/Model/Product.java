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
public class Product {

    private int id;
    private String name;
    private String image;
    private double price;
    private String title;
    private String des;
    private String bcid;

    public Product() {
        connect();
    }

    public Product(int id, String name, String image, double price, String title, String des,  String bcid) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.title = title;
        this.des = des;
        this.bcid =bcid;
        connect();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getBcid() {
        return bcid;
    }

    public void setBcid(String bcid) {
        this.bcid = bcid;
    }
    

    Connection cnn;//kết nối DB
    Statement stm;//Thực thi câu lệnh
    PreparedStatement pstm;//Thuc thi SQL
    ResultSet rs;//Lưu trữ và sử lý dữ liệu

    public ArrayList<Product> getListProduct() {
        ArrayList<Product> data = new ArrayList<Product>();
        try {
            String strSelect = "select * from product ";
            pstm = cnn.prepareStatement(strSelect);
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String des = rs.getString(6);
                String bcid = rs.getString(7);
                data.add(new Product(id, name, image, price, title, des,bcid));

            }
        } catch (Exception e) {
            System.out.println("getListProduct:" + e.getMessage());
        }
        return data;
    }

//    public ArrayList<Product> getListProductBC() {
//        ArrayList<Product> data = new ArrayList<Product>();
//        try {
//            String strSelect = "select * from product where BC_ID = 1";
//
//            pstm = cnn.prepareStatement(strSelect);
//            rs = pstm.executeQuery();
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String name = rs.getString(2);
//                String image = rs.getString(3);
//                double price = rs.getDouble(4);
//                String title = rs.getString(5);
//                String des = rs.getString(6);
//
//                data.add(new Product(id, name, image, price, title, des));
//
//            }
//        } catch (Exception e) {
//            System.out.println("getListProduct:" + e.getMessage());
//        }
//        return data;
//    }
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

    public ArrayList<Product> getListProductCid(String cidd) {
        ArrayList<Product> data = new ArrayList<Product>();
        try {
            String strSelect = "select * from product "
                    + "where cateID = ?";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(cidd));
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String des = rs.getString(6);
                String bcid = rs.getString(7);
                data.add(new Product(id, name, image, price, title, des,bcid));

            }
        } catch (Exception e) {
            System.out.println("getListProductCid:" + e.getMessage());
        }
        return data;
    }

    public Product getListProductid(String idd) {
        try {
            String strSelect = "select * from product "
                    + "where id = ?";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(idd));
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String des = rs.getString(6);
                String bcid = rs.getString(7);
                return new Product(id, name, image, price, title, des,bcid);

            }
        } catch (Exception e) {
            System.out.println("getListProductid:" + e.getMessage());
        }
        return null;
    }

    public ArrayList<Product> getListProductSell(String selid) {
        ArrayList<Product> data = new ArrayList<Product>();
        try {
            String strSelect = "select * from product where sell_ID = ?";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(selid));
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String des = rs.getString(6);
                String bcid = rs.getString(7);
                data.add(new Product(id, name, image, price, title, des,bcid));

            }
        } catch (Exception e) {
            System.out.println("getListProductSell:" + e.getMessage());
        }
        return data;
    }

    public void deleteproduct(String id) {
        try {
            String strDelete = "DELETE FROM product\n"
                    + "WHERE id = ?";

            pstm = cnn.prepareStatement(strDelete);
            pstm.setInt(1, Integer.parseInt(id));
            pstm.execute();
        } catch (Exception e) {
            System.out.println("deleteproduct:" + e.getMessage());
        }

    }

    public void addProduct(String name, String image, String price, String title, String description, String category, String sid) {
        try {
            String strDelete = "INSERT [dbo].[product] \n"
                    + "([name], [image], [price], [title], [description], [cateID], [sell_ID])\n"
                    + "VALUES(?,?,?,?,?,?,?)";

            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, name);
            pstm.setString(2, image);
            pstm.setString(3, price);
            pstm.setString(4, title);
            pstm.setString(5, description);
            pstm.setString(6, category);
            pstm.setString(7, sid);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("addProduct:" + e.getMessage());
        }
    }

    public void editProduct(String name, String image, String price, String title, String description, String category, String sid) {
        try {
            String strDelete = "update product set [name] = ?,[image] = ?,price = ?,title = ?,[description] = ?,cateID = ? where id = ?";

            pstm = cnn.prepareStatement(strDelete);
            pstm.setString(1, name);
            pstm.setString(2, image);
            pstm.setString(3, price);
            pstm.setString(4, title);
            pstm.setString(5, description);
            pstm.setString(6, category);
            pstm.setString(7, sid);
            pstm.execute();
        } catch (Exception e) {
            System.out.println("editProduct:" + e.getMessage());
        }
    }

    public ArrayList<Product> getListProductbid(String bidd) {
        ArrayList<Product> data = new ArrayList<Product>();
        try {
            String strSelect = "select * from product where  BC_ID = 1 ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setInt(1, Integer.parseInt(bidd));
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String des = rs.getString(6);
                String bcid = rs.getString(7);
                data.add(new Product(id, name, image, price, title, des,bcid));

            }
        } catch (Exception e) {
            System.out.println("getListProductbid:" + e.getMessage());
        }
        return data;
    }

    public ArrayList<Product> getListProductSearch(String text) {
        ArrayList<Product> data = new ArrayList<Product>();
        try {
            String strSelect = "select * from product where [name] like ? ";

            pstm = cnn.prepareStatement(strSelect);
            pstm.setString(1, "%"+text+"%");
            rs = pstm.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String image = rs.getString(3);
                double price = rs.getDouble(4);
                String title = rs.getString(5);
                String des = rs.getString(6);
                String bcid = rs.getString(7);
                data.add(new Product(id, name, image, price, title, des,bcid));

            }
        } catch (Exception e) {
            System.out.println("getListProductSearch:" + e.getMessage());
        }
        return data;
    }

}
