package com.example.crud;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteServlet",value = "/delete-servlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();


        int id = Integer.parseInt(req.getParameter("id"));
        int status = 0;
        status = EmpDao.delete(id);

        if (status > 0){
             resp.sendRedirect("view-servlet");
        } else {
            out.print("Không xoá thành công");
            req.getRequestDispatcher("view-servlet").include(req,resp);
        }
    }

}
