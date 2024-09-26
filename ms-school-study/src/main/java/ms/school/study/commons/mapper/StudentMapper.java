package ms.school.study.commons.mapper;

import ms.school.study.commons.dto.StudentDto;
import ms.school.study.commons.entity.Student;

public class StudentMapper {

    public static Student toEntity(StudentDto studentDto) {

        Student student = new Student();
        student.setStudentId(studentDto.getStudentId());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setDateOfBirth(studentDto.getDateOfBirth());
        student.setMajor(studentDto.getMajor());
        student.setYearOfEntry(studentDto.getYearOfEntry());
        student.setAddress(studentDto.getAddress());
        return student;
    }

    public static StudentDto toDto(Student student) {

        StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setName(student.getName());
        studentDto.setEmail(student.getEmail());
        studentDto.setPhoneNumber(student.getPhoneNumber());
        studentDto.setDateOfBirth(student.getDateOfBirth());
        studentDto.setMajor(student.getMajor());
        studentDto.setYearOfEntry(student.getYearOfEntry());
        studentDto.setAddress(student.getAddress());
        return studentDto;
    }
}
