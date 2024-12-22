package com.teachercloud.service;

import org.springframework.stereotype.Service;

import com.teachercloud.IService.ICourseService;
import com.teachercloud.model.Course;
import com.teachercloud.repository.EntidadRepository;


@Service
public class CourseService extends EntidadService<Course> implements ICourseService {
    // private final CourseRepository courseRepository;

    public CourseService(EntidadRepository<Course> courseRepository){
        super(courseRepository);
        // this.courseRepository = courseRepository;
    }
}
