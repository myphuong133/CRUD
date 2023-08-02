package com.example.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditServlet", value = "/edit-servlet")
public class EditServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("idEmp"));
        String nameEmp = req.getParameter("nameEmp");
        String passEmp = req.getParameter("passEmp");
        String emailEmp = req.getParameter("emailEmp");
        String countryEmp = req.getParameter("countryEmp");

        Emp emp = new Emp(id,nameEmp,passEmp,emailEmp,countryEmp);
        System.out.println(emp.getNameEmp());
        PrintWriter out = resp.getWriter();
        int status = EmpDao.update(emp);
        if (status > 0){
            resp.sendRedirect("view-servlet");
        } else {
            out.print("Sorry! Unable to update " + "return at" + "<a href='view-servlet'>here<a/>");

        }
    }
}
