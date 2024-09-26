package ms.school.study.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ms.school.study.commons.dto.StudentDto;
import ms.school.study.commons.entity.Student;
import ms.school.study.commons.exception.ResourceNotFoundException;
import ms.school.study.commons.mapper.StudentMapper;
import ms.school.study.repository.StudentRepository;
import ms.school.study.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream()
                .map(StudentMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto findById(String studentId) {
        return StudentMapper.toDto(studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", studentId)));
    }

    @Override
    @Transactional
    public StudentDto create(StudentDto studentDTO) {
        Student student = StudentMapper.toEntity(studentDTO);
        return StudentMapper.toDto(studentRepository.save(student));
    }

    @Override
    @Transactional
    public StudentDto update(String studentId, StudentDto studentDTO) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", studentId));
        existingStudent.setName(studentDTO.getName());
        existingStudent.setEmail(studentDTO.getEmail());
        existingStudent.setPhoneNumber(studentDTO.getPhoneNumber());
        existingStudent.setDateOfBirth(studentDTO.getDateOfBirth());
        existingStudent.setMajor(studentDTO.getMajor());
        existingStudent.setYearOfEntry(studentDTO.getYearOfEntry());
        existingStudent.setAddress(studentDTO.getAddress());
        return StudentMapper.toDto(studentRepository.save(existingStudent));
    }

    @Override
    @Transactional
    public void delete(String studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "studentId", studentId));
        studentRepository.delete(student);
    }

}
