package com.mini.school.erp.course_service.validation.business;

import com.mini.school.erp.course_service.exception.errormessages.ErrorMessages;
import com.mini.school.erp.course_service.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BusinessValidation {

    private final CourseRepository courseRepository;

    public void validateCourseNameUnique(String courseName) {
        courseRepository.findByCourseNameIgnoreCase(courseName)
                .ifPresent(c -> {
                    throw new RuntimeException(ErrorMessages.COURSE_NAME + courseName + ErrorMessages.COURSE_ALREADY);
                });
    }
}
