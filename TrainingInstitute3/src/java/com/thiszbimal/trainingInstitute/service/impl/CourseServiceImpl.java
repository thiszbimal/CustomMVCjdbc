/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thiszbimal.trainingInstitute.service.impl;

import com.thiszbimal.trainingInstitute.dao.CourseDAO;
import com.thiszbimal.trainingInstitute.dao.impl.CourseDAOImpl;
import com.thiszbimal.trainingInstitute.entity.Course;
import com.thiszbimal.trainingInstitute.service.CourseService;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author admin
 */
public class CourseServiceImpl implements CourseService{
    private CourseDAO courseDAO=new CourseDAOImpl();

    @Override
    public int insert(Course c) throws SQLException, ClassNotFoundException {
        return courseDAO.insert(c);
    }

    @Override
    public int update(Course c) throws SQLException, ClassNotFoundException {
        return courseDAO.update(c);
    }

    @Override
    public int delete(int id) throws SQLException, ClassNotFoundException {
        return courseDAO.delete(id);
    }

    @Override
    public Course getbyId(int id) throws SQLException, ClassNotFoundException {
        return courseDAO.getbyId(id);
    }

    @Override
    public List<Course> getAll(boolean show) throws SQLException, ClassNotFoundException {
        return courseDAO.getAll(show);
    }

    @Override
    public int count() throws SQLException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
