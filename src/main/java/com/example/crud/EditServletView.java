package com.example.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name = "EditServletView", value = "/edit-servlet-view")
public class EditServletView extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        // Lấy nhân viên từ id được gửi từ view
        int id = Integer.parseInt(req.getParameter("id"));
        EmpDao empDao = new EmpDao();
        Emp e = empDao.getEmployee(id);
        System.out.println(e.getNameEmp());
        // In ra form chỉnh sửa và gửi thêm id ẩn
        out.print("<h1> Edit Employee </h1>");
        out.print("<form action='edit-servlet' method='post'>" +
                "<table>" +
                "<tr> <td> <input type = 'hidden' name='idEmp' value =" + e.getIdEmp() + "> </td> </tr>" +
                "<tr> <td>Name: </td>       <td> <input type = 'text' name='nameEmp' value = '" + e.getNameEmp() + "'> </td> </tr>" +
                "<tr> <td>Password: </td>   <td> <input type = 'password' name='passEmp' value = '" + e.getPassEmp() + "'> </td> </tr>" +
                "<tr> <td>Email: </td>      <td> <input type = 'email' name='emailEmp' value = '" + e.getEmailEmp() + "'> </td> </tr>" +
                "<tr> <td>Country </td>  " +
                    "<td>" +
                    "<select name='countryEmp'>" + printCountryOption(e.getCountryEmp())  +
                    "</select>" +
                    "</td>" +
                "</tr>" +
                "<tr>  <td> <input type = 'submit' value = 'Save & Edit'> </td> </tr>" +
                "</table>" +
                "</form>");
        out.println("Add Employee at " + "<a href='/crud/index.jsp'>here<a/>");
        out.println("View Employee at " + "<a href='view-servlet'>here<a/>");
        out.close();
    }
    public String printCountryOption(String empCountry){
        String res = "";
        String[] countryList = {"Japan","Viet Nam","USA","UK","India","Other"};
        for (String country: countryList
             ) {
            if (country.equals(empCountry)){
                res += "<option selected>"+ country + "</option>";
            } else {
                res += "<option>"+ country + "</option>";
            }
        }
        System.out.println(res);
        return res;
    }
}
