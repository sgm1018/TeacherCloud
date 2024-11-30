package com.teachercloud.service;

import com.teachercloud.IService.ICourseService;
import com.teachercloud.model.Course;
import com.teachercloud.repository.CourseRepository;

public class CourseService extends EntidadService<Course> implements ICourseService {
    // private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        super(courseRepository);
        // this.courseRepository = courseRepository;
    }
}
