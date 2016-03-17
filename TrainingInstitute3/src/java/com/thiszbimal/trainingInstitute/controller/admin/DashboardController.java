/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.trainingInstitute.controller.admin;

import com.thiszbimal.trainingInstitute.service.CourseService;
import com.thiszbimal.trainingInstitute.service.impl.CourseServiceImpl;
import com.thiszbimal.trainingInstitute.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */

@WebServlet (name = "dashboard", urlPatterns = {"/admin/"})
public class DashboardController extends Controller{
    CourseService courseService=new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Content-type", "text/html");
        PrintWriter out = response.getWriter();
        try {
            request.setAttribute("courses", courseService.getAll(false));
            request.getRequestDispatcher("/WEB-INF/Views/admin/index.jsp").forward(request, response);
        } catch (SQLException ex) {
            out.println("<h1>"+ ex.getMessage()+ "</h1>");
        } catch (ClassNotFoundException ex) {
            out.println("<h1>"+ ex.getMessage()+ "</h1>");
        }
    }
    
}
