package com.example.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SaveServlet", value = "/save-servlet")
public class SaveServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("nameEmp");
        String password = req.getParameter("passEmp");
        String email = req.getParameter("emailEmp");
        String country = req.getParameter("countryEmp");

        PrintWriter out = resp.getWriter();

        if (name == null || name.equals("")) {
            System.out.println("Wrong");
            out.print("<p style='color: red" + "'>Pls fill all the value!</p>");
            req.getRequestDispatcher("/crud/index.jsp").include(req, resp);
        } else {
            Emp empSaver = new Emp(name, password, email, country);
            int status = EmpDao.save(empSaver);
            if (status > 0){
                out.print("<p style='color: red" + "'> Success!</p>");
                req.getRequestDispatcher("/crud/index.jsp").include(req, resp);
            } else {
                System.out.println("Wrong");
                out.print("<p style='color: red" + "'>Pls fill all the value!</p>");
                req.getRequestDispatcher("/crud/index.jsp").include(req, resp);
            }
        }
    }
}
