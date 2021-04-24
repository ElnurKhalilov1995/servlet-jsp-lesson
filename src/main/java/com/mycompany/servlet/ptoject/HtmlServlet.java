/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.servlet.ptoject;

import com.mycompany.servlet.ptoject.entity.Client;
import dao.DbConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "HtmlServlet", urlPatterns = {"/HtmlServlet"})
public class HtmlServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {   
            String url = "jdbc:mysql://localhost:3306/mini_cft";
            String user = "root";
            String pass = "Elnur1995";

            DbConnection db = new DbConnection(url, user, pass);
            
            request.setAttribute("clients", db.findAllClient());

            RequestDispatcher dispatcher = request.getRequestDispatcher("newjsp.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(HtmlServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
