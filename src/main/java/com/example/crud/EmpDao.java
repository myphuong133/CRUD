package com.example.crud;

import java.sql.*;
import java.util.ArrayList;

public class EmpDao {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/servletcrud";
    private static final String USER = "root";
    private static final String PASSWORD = "tung";

    public static Connection getConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con  = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    public static int save(Emp emp){
        int status = 0;

        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps =  con.prepareStatement("INSERT INTO user905 (name,password,email,country) VALUES (?,?,?,?)");
            ps.setString(1,emp.getNameEmp());
            ps.setString(2,emp.getPassEmp());
            ps.setString(3,emp.getEmailEmp());
            ps.setString(4,emp.getCountryEmp());

            status = ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static int update(Emp emp){
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("UPDATE user905 SET name=?,password=?,email=?,country=? WHERE id = ?");

            ps.setString(1,emp.getNameEmp());
            ps.setString(2,emp.getPassEmp());
            ps.setString(3,emp.getEmailEmp());
            ps.setString(4,emp.getCountryEmp());
            ps.setInt(5,emp.getIdEmp());

            status = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static int delete(int id){
        int status = 0;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("DELETE FROM user905 WHERE id=?");
            ps.setInt(1,id);
            status = ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return status;
    }

    public static Emp getEmployee(int id){
        Emp emp = null;
        try {
            Connection con = EmpDao.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user905 WHERE id=?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                emp = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4), rs.getString(5));
            }con.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emp;
    }





    public ArrayList<Emp> getEmps(){
        ArrayList<Emp> emps = new ArrayList<>();

        Connection con = EmpDao.getConnection();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM user905");
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Emp e = new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                emps.add(e);
            }
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return emps;
    }

    public static void main(String[] args) {
        Emp emp = new Emp(1, "Vũ Duy Khánh", "vuduykhanh123", "vuduykhanh14022004@gmail.com", "Tiểu vương quốc Thanh Hoá");
        EmpDao empDao = new EmpDao();
        Emp emp1 = empDao.getEmployee(1);


    }
}

