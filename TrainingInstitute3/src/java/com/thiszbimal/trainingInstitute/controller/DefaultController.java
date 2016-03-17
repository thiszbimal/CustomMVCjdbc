/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.trainingInstitute.controller;

import com.thiszbimal.trainingInstitute.service.CourseService;
import com.thiszbimal.trainingInstitute.service.impl.CourseServiceImpl;
import com.thiszbimal.trainingInstitute.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "default", urlPatterns = {"/"})
public class DefaultController extends Controller{
    CourseService courseService=new CourseServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setHeader("Content-type", "text/html");
        try{
        request.setAttribute("courses", courseService.getAll(false));
        request.getRequestDispatcher("/WEB-INF/Views/front/index.jsp").forward(request, response);
        }catch(Exception ex){
            out.println(ex.getMessage());
        }
    }
    
}
