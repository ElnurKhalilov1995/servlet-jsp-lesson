/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet.ptoject;

import dao.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ehkhalilov
 */
@WebServlet(name = "ClientDetails", urlPatterns = {"/ClientDetails"})
public class ClientDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "jdbc:mysql://localhost:3306/mini_cft";
        String user = "root";
        String pass = "Elnur1995";
        
        Integer id = Integer.parseInt(request.getParameter("id"));
        
        DbConnection db = new DbConnection(url, user, pass);
        System.out.println("id: " + id);
        request.setAttribute("client", db.findByIdClient(id));

        RequestDispatcher dispatcher = request.getRequestDispatcher("client_detail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
