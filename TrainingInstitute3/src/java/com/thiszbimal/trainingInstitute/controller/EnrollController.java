/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.trainingInstitute.controller;

import com.thiszbimal.trainingInstitute.entity.Course;
import com.thiszbimal.trainingInstitute.entity.Enquiry;
import com.thiszbimal.trainingInstitute.service.CourseService;
import com.thiszbimal.trainingInstitute.service.EnquiryService;
import com.thiszbimal.trainingInstitute.service.impl.CourseServiceImpl;
import com.thiszbimal.trainingInstitute.service.impl.EnquiryServiceImpl;
import com.thiszbimal.trainingInstitute.system.Controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "enroll", urlPatterns = {"/enroll/*"})
public class EnrollController extends Controller{
    private EnquiryService enquiryService = new EnquiryServiceImpl();
    private CourseService courseService = new CourseServiceImpl();
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       try{
        request.setAttribute("courses",courseService.getAll(false));
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        request.getRequestDispatcher("/WEB-INF/Views/front/enroll/index.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try{
            Enquiry enquiry=new Enquiry();
            enquiry.setFirstName(request.getParameter("first_name"));
            enquiry.setLastName(request.getParameter("last_name"));
            enquiry.setEmail(request.getParameter("email"));
            enquiry.setContactNo(request.getParameter("contact_no"));
            Course course=new Course();
            
            course.setId(Integer.parseInt(request.getParameter("course")));
            
            enquiry.setCourse(course);
            enquiry.setMessage(request.getParameter("message"));
            
            enquiryService.insert(enquiry);
            sendEmail(enquiry);
            out.println("<h1>Thank you sir</h1>");
           
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    
    public void sendEmail(Enquiry e){
// Recipient's email ID needs to be mentioned.
      String to = "thiszbimal@gmail.com";

      // Sender's email ID needs to be mentioned
      String from = e.getEmail();

      // Assuming you are sending email from localhost
      String host = "smtp.wlink.com.np";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.setProperty("mail.smtp.host", host);

      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("Enrollment for");

         // Now set the actual message
         message.setText(e.getMessage());

         // Send message
         Transport.send(message);
          System.out.println("<h1>Sent message successfully....</h1>");
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }        
    }
    
}
