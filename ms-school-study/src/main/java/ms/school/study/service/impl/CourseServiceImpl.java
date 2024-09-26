package ms.school.study.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ms.school.study.commons.dto.CourseDto;
import ms.school.study.commons.entity.Course;
import ms.school.study.commons.exception.ResourceNotFoundException;
import ms.school.study.commons.mapper.CourseMapper;
import ms.school.study.repository.CourseRepository;
import ms.school.study.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseDto> getAll() {
        return courseRepository.findAll().stream()
                .map(CourseMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CourseDto findById(String courseId) {
        return courseRepository.findById(courseId)
                .map(CourseMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));
    }

    @Override
    @Transactional
    public CourseDto create(CourseDto courseDTO) {
        Course course = CourseMapper.toEntity(courseDTO);
        return CourseMapper.toDto(courseRepository.save(course));
    }

    @Override
    public CourseDto update(String courseId, CourseDto courseDTO) {
        Course existingCourse = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));
        existingCourse.setCourseName(courseDTO.getCourseName());
        existingCourse.setCredits(courseDTO.getCredits());
        existingCourse.setSemester(courseDTO.getSemester());
        existingCourse.setDepartment(courseDTO.getDepartment());
        existingCourse.setDescription(courseDTO.getDescription());
        return CourseMapper.toDto(courseRepository.save(existingCourse));
    }

    @Override
    @Transactional
    public void delete(String courseId) {
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course", "courseId", courseId));
        courseRepository.delete(course);
    }
}
