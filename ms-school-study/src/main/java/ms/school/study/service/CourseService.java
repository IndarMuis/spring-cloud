package ms.school.study.service;

import ms.school.study.commons.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAll();

    CourseDto findById(String courseId);

    CourseDto create(CourseDto courseDTO);

    CourseDto update(String courseId, CourseDto courseDTO);

    void delete(String courseId);
}
