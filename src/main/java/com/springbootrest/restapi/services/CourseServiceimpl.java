package com.springbootrest.restapi.services;

import com.springbootrest.restapi.dao.CourseDao;
import com.springbootrest.restapi.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    //List<Course> list;

    CourseServiceimpl(){
        //list = new ArrayList<Course>();
        //list.add(new Course(1,"COMP 249","Object Oriented Programming in Java"));
        //list.add(new Course(2,"COMP 232", "Discrete Mathematics"));
    }


    @Override
    public List<Course> getCourses(){
        return courseDao.findAll();
    }

    @Override
    public Course getCourse(long courseId){

        return courseDao.findById(courseId).get();
        /*       Course c = null;
        for(Course a : list){
            if(a.getId() == courseId){
                c = a;
                break;
            }
        }*/
    }

    @Override
    public Course addCourse(Course course) {
        //list.add(course);
        courseDao.save(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
       courseDao.save(course);
        /* for(Course a : list){
            if(course.getId() == a.getId()){
                a.setTitle(course.getTitle());
                a.setDescription(course.getDescription());
                break;
            }*/
        return course;
    }

    public void deleteCourse(long courseId){
        courseDao.delete(courseDao.findById(courseId).get());
/*        for(Course a : list) {
            if (a.getId() == courseId) {
                list.remove(a);
                return a;
            }
        }*/
    }

}
