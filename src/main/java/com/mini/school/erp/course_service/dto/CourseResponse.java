package com.mini.school.erp.course_service.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String courseName;
    private String description;
}