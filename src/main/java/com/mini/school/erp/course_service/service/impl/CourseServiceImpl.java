package com.mini.school.erp.course_service.service.impl;

import com.mini.school.erp.course_service.dto.CourseCreateRequest;
import com.mini.school.erp.course_service.dto.CourseResponse;
import com.mini.school.erp.course_service.entity.Course;
import com.mini.school.erp.course_service.exception.BusinessValidationException;
import com.mini.school.erp.course_service.exception.errormessages.ErrorMessages;
import com.mini.school.erp.course_service.repository.CourseRepository;
import com.mini.school.erp.course_service.service.CourseService;
import com.mini.school.erp.course_service.validation.business.BusinessValidation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final BusinessValidation businessValidation;

    @Override
    public CourseResponse createCourse(CourseCreateRequest request) {
        businessValidation.validateCourseNameUnique(request.getCourseName());

        Course course = Course.builder()
                .courseName(request.getCourseName())
                .description(request.getDescription())
                .build();

        courseRepository.save(course);

        return mapToResponse(course);
    }

    @Override
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponse getCourseById(Long id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new BusinessValidationException(ErrorMessages.COURSE_NOT_FOUND + id));
        return mapToResponse(course);
    }

    private CourseResponse mapToResponse(Course course) {
        return CourseResponse.builder()
                .id(course.getId())
                .courseName(course.getCourseName())
                .description(course.getDescription())
                .build();
    }
}