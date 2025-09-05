package com.mini.school.erp.course_service.repository;

import com.mini.school.erp.course_service.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseNameIgnoreCase(String courseName);
}
