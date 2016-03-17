/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.trainingInstitute.controller;

import com.thiszbimal.trainingInstitute.entity.Course;
import com.thiszbimal.trainingInstitute.service.CourseService;
import com.thiszbimal.trainingInstitute.service.impl.CourseServiceImpl;
import com.thiszbimal.trainingInstitute.system.Controller;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "course" , urlPatterns = {"/course/*"})
public class CourseController extends Controller{
    CourseService courseService = new CourseServiceImpl();
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String path=request.getRequestURI().toLowerCase();
        try{
            if(path.contains("/detail")){
                
                if(request.getParameter("id")!=null && !request.getParameter("id").isEmpty()){
                    
                    int id=Integer.parseInt(request.getParameter("id"));
                    Course course=courseService.getbyId(id);
                    
                    if(course!=null){
                        request.setAttribute("course",course);
                        request.getRequestDispatcher("/WEB-INF/Views/front/course/detail.jsp").forward(request, response);
                    }
                    else{
                        response.sendRedirect(request.getContextPath());
                    }
                    
                    

                }
            }
            
        }
        catch(Exception e){
            
            System.out.println(e.getMessage());
            response.sendRedirect(request.getContextPath());
        }  
    }
   
}
