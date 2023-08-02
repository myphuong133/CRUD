package com.example.crud;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ViewServlet", value = "/view-servlet")
public class ViewServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        ArrayList<Emp> emps1 = new ArrayList<>();
        EmpDao empDao = new EmpDao();
        emps1 = empDao.getEmps();

        out.println("<h1> Employees List</h1>");
        out.println("<table border='1' >");
        out.println(
                "<tr>" +
                    "<th>" +
                        "ID" +
                    "</th>" +
                    "<th>" +
                        "Name" +
                    "</th>" +
                    "<th>" +
                        "Password" +
                    "</th>" +
                    "<th>" +
                        "Email" +
                    "</th>" +
                    "<th>" +
                        "Country" +
                    "</th>" +
                    "<th>" +
                        "Edit" +
                    "</th>" +
                    "<th>" +
                        "Delete" +
                    "</th>" +
                "</tr>");
        for (Emp e : emps1) {
            out.println(
                    "<tr>" +
                            "<td>" +
                                e.getIdEmp() +
                            "</td>" +
                            "<td>" +
                                e.getNameEmp() +
                            "</td>" +
                            "<td>" +
                                e.getPassEmp() +
                            "</td>" +
                            "<td>" +
                                e.getEmailEmp() +
                            "</td>" +
                            "<td>" +
                                e.getCountryEmp() +
                            "</td>" +
                            "<td>" +
                            "<a href= " + "/edit-servlet-view?id=" +  e.getIdEmp() + ">Edit </a>" +
                            "</td>" +
                            "<td>" +
                            "<a href= " + "/delete-servlet?id=" +  e.getIdEmp() + ">Delete </a>" +
                            "</td>" +
                            "</tr>");
        }
        out.println("</table>");
        out.print("add Employee at " + "<a href='/crud/index.jsp'>here<a/>");
    }
    public void destroy() {

    }
}