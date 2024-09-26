package ms.school.study.commons.mapper;

import ms.school.study.commons.dto.StudentEnrollmentDto;
import ms.school.study.commons.entity.StudentEnrollment;

public class StudentEnrollmentMapper {
    public static StudentEnrollment toEntity(StudentEnrollmentDto enrollmentDto) {
        StudentEnrollment enrollment = new StudentEnrollment();
        enrollment.setEnrollmentId(enrollmentDto.getEnrollmentId());
        enrollment.setStudentId(enrollmentDto.getStudentId());
        enrollment.setScheduleId(enrollmentDto.getScheduleId());
        enrollment.setEnrollmentDate(enrollmentDto.getEnrollmentDate());
        enrollment.setStatus(enrollmentDto.getStatus());
        return enrollment;
    }

    public static StudentEnrollmentDto toDTO(StudentEnrollment enrollment) {
        StudentEnrollmentDto enrollmentDto = new StudentEnrollmentDto();
        enrollmentDto.setEnrollmentId(enrollment.getEnrollmentId());
        enrollmentDto.setStudentId(enrollment.getStudentId());
        enrollmentDto.setScheduleId(enrollment.getScheduleId());
        enrollmentDto.setEnrollmentDate(enrollment.getEnrollmentDate());
        enrollmentDto.setStatus(enrollment.getStatus());
        return enrollmentDto;
    }
}
