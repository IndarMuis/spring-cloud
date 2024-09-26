package ms.school.study.service;

import ms.school.study.commons.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getAll();

    StudentDto findById(String studentId);

    StudentDto create(StudentDto studentDTO);

    StudentDto update(String studentId, StudentDto studentDTO);

    void delete(String studentId);
}
