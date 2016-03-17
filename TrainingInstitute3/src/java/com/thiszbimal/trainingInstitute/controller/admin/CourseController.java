/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.trainingInstitute.controller.admin;

import com.thiszbimal.trainingInstitute.entity.Course;
import com.thiszbimal.trainingInstitute.service.CourseService;
import com.thiszbimal.trainingInstitute.service.impl.CourseServiceImpl;
import com.thiszbimal.trainingInstitute.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Calendar;
import javafx.scene.control.Alert;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */@WebServlet(name = "AdminCourseController", urlPatterns = {"/c/*"})
public class CourseController extends Controller{
    CourseService courseService = new CourseServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI().toLowerCase();
        PrintWriter out = response.getWriter();
        
        if(path.contains("/add")){
            request.getRequestDispatcher("/WEB-INF/Views/admin/course/add.jsp").forward(request, response);
        }
         if(path.contains("/delete")){
             
              if((request.getParameter("id")!=null)&&!(request.getParameter("id").isEmpty())){
                try{
                int id = Integer.parseInt(request.getParameter("id"));
                Course course = courseService.getbyId(id);
                courseService.delete(id);
                response.sendRedirect(request.getContextPath()+"/admin/");
                
                //courseService.delete(id);
                }catch(Exception ex){
                    response.getWriter().println(ex.getMessage());
                }
                
            }
              
         }
         
        if(path.contains("/edit")){
            if((request.getParameter("id")!=null)&&!(request.getParameter("id").isEmpty())){
                try{
                int id = Integer.parseInt(request.getParameter("id"));
                Course course = courseService.getbyId(id);
                
                if(course!=null){
                    request.setAttribute("c",course);
                    request.getRequestDispatcher("/WEB-INF/Views/admin/course/edit.jsp").forward(request, response);
                }
                else
                    response.sendRedirect(request.getContextPath());
                }catch(Exception ex){
                    out.println(ex.getMessage());
                }
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getRequestURI().toLowerCase();
        if(path.contains("/save")){
            try{
            Course c = new Course();
            c.setName(request.getParameter("name"));
            c.setDescription(request.getParameter("description"));
            c.setFees(Double.parseDouble(request.getParameter("fees")));
            c.setDuration(Integer.parseInt(request.getParameter("duration")));
            c.setDurationType(request.getParameter("durationType"));
            c.setStatus(Boolean.parseBoolean(request.getParameter("status")));
            
            courseService.insert(c);
            response.getWriter().println("<h1>Successfully Inserted</h1>");
            }catch(Exception ex){
                response.getWriter().println(ex.getMessage());
            }
            
        }
        
        if(path.contains("/update")){
            Course c = new Course();
            try{
                c.setId(Integer.parseInt(request.getParameter("id")));
                c.setName(request.getParameter("name"));
                c.setDescription((request.getParameter("description")));
                c.setFees(Double.parseDouble(request.getParameter("fees")));
                c.setDuration(Integer.parseInt(request.getParameter("duration")));
                c.setDurationType(request.getParameter("durationType"));
                c.setModifiedDate(new Date(Calendar.getInstance().getTimeInMillis()));
                c.setStatus(Boolean.parseBoolean(request.getParameter("status")));
                
                
                courseService.update(c);
                response.getWriter().println("successfully Updated......");
            }catch(Exception ex){
                response.getWriter().println(ex.getMessage());
            }
        }
        
       
       
    }
}
    
    
    
    
    

