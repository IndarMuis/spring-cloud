package ms.school.study.commons.mapper;

import ms.school.study.commons.dto.CourseDto;
import ms.school.study.commons.entity.Course;

public class CourseMapper {
    public static Course toEntity(CourseDto courseDTO) {
        Course course = new Course();
        course.setCourseId(courseDTO.getCourseId());
        course.setCourseName(courseDTO.getCourseName());
        course.setCredits(courseDTO.getCredits());
        course.setSemester(courseDTO.getSemester());
        course.setDepartment(courseDTO.getDepartment());
        course.setDescription(courseDTO.getDescription());
        return course;
    }

    public static CourseDto toDto(Course course) {
        CourseDto courseDTO = new CourseDto();
        courseDTO.setCourseId(course.getCourseId());
        courseDTO.setCourseName(course.getCourseName());
        courseDTO.setCredits(course.getCredits());
        courseDTO.setSemester(course.getSemester());
        courseDTO.setDepartment(course.getDepartment());
        courseDTO.setDescription(course.getDescription());
        return courseDTO;
    }
}
