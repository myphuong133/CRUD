package com.example.crud;

import java.sql.*;

public class Test {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/servletcrud";
        String user = "root";
        String password = "tung";

        ResultSet rs;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,user,password);

            PreparedStatement ps = con.prepareStatement("");

            System.out.println(ps.executeUpdate());



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
