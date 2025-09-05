package com.mini.school.erp.course_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseCreateRequest {

    @NotBlank(message = "Course name is required")
    @Size(max = 150, message = "Course name must not exceed 150 characters")
    private String courseName;

    private String description;
}