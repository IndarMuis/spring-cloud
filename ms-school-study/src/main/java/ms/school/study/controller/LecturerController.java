package ms.school.study.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ms.school.study.commons.dto.LecturerDto;
import ms.school.study.service.LecturerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/v1/study/lecturers")
public class LecturerController {
    private final LecturerService lecturerService;

    @GetMapping
    public ResponseEntity<List<LecturerDto>> getAll() {
        return ResponseEntity.ok(lecturerService.getAll());
    }

    @GetMapping("/{lecturerId}")
    public ResponseEntity<LecturerDto> findById(@PathVariable String lecturerId) {
        return ResponseEntity.ok(lecturerService.findById(lecturerId));
    }

    @PostMapping
    public ResponseEntity<LecturerDto> create(@Valid @RequestBody LecturerDto lecturerDTO) {
        LecturerDto createdLecturer = lecturerService.create(lecturerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLecturer);
    }

    @PutMapping("/{lecturerId}")
    public ResponseEntity<LecturerDto> update(@PathVariable String lecturerId,
                                              @Valid @RequestBody LecturerDto lecturerDTO) {
        LecturerDto updatedLecturer = lecturerService.update(lecturerId, lecturerDTO);
        return ResponseEntity.ok(updatedLecturer);
    }

    @DeleteMapping("/{lecturerId}")
    public ResponseEntity<Void> delete(@PathVariable String lecturerId) {
        lecturerService.delete(lecturerId);
        return ResponseEntity.noContent().build();
    }
}
