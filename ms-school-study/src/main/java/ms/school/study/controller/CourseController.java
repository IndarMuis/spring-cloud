package ms.school.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ms.school.study.commons.dto.CourseDto;
import ms.school.study.commons.dto.ResponseDto;
import ms.school.study.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/study/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public ResponseEntity<ResponseDto<List<CourseDto>>> getAll() {
        List<CourseDto> courseDtoList = courseService.getAll();
        return new ResponseEntity<>(
                new ResponseDto<>("200", "OK", courseDtoList),
                HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<ResponseDto<CourseDto>> findById(@PathVariable String courseId) {
        CourseDto courseDto = courseService.findById(courseId);
        return new ResponseEntity<>(
                new ResponseDto<>("200", "OK", courseDto),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseDto<CourseDto>> create(@Valid @RequestBody CourseDto courseDTO) {
        CourseDto createdCourse = courseService.create(courseDTO);
        return new ResponseEntity<>(
                new ResponseDto<>("201", "Created", createdCourse),
                HttpStatus.CREATED);
    }

    @PutMapping("/{courseId}")
    public ResponseEntity<ResponseDto<CourseDto>> update(@PathVariable String courseId,
                                                         @Valid @RequestBody CourseDto courseDTO) {
        CourseDto updatedCourse = courseService.update(courseId, courseDTO);
        return new ResponseEntity<>(
                new ResponseDto<>("200", "OK", updatedCourse),
                HttpStatus.OK);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<ResponseDto<Void>> deleteCourse(@PathVariable String courseId) {
        courseService.delete(courseId);
        return new ResponseEntity<>(
                new ResponseDto<>("200", "Deleted Successful", null),
                HttpStatus.OK);
    }

}
