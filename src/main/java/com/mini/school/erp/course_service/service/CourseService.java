package com.mini.school.erp.course_service.service;

import com.mini.school.erp.course_service.dto.CourseCreateRequest;
import com.mini.school.erp.course_service.dto.CourseResponse;

import java.util.List;

public interface CourseService {
    CourseResponse createCourse(CourseCreateRequest request);
    List<CourseResponse> getAllCourses();
    CourseResponse getCourseById(Long id);
}
