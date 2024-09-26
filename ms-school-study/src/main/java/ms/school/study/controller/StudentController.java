package ms.school.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ms.school.study.commons.dto.StudentDto;
import ms.school.study.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/study/students")
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> findById(@PathVariable String studentId) {
        return ResponseEntity.ok(studentService.findById(studentId));
    }

    @PostMapping
    public ResponseEntity<StudentDto> create(@Valid @RequestBody StudentDto studentDTO) {
        StudentDto createdStudent = studentService.create(studentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<StudentDto> update(@PathVariable String studentId,
                                                    @Valid @RequestBody StudentDto studentDTO) {
        StudentDto updatedStudent = studentService.update(studentId, studentDTO);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> delete(@PathVariable String studentId) {
        studentService.delete(studentId);
        return ResponseEntity.noContent().build();
    }

}
