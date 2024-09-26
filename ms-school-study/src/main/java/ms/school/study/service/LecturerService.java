package ms.school.study.service;

import ms.school.study.commons.dto.LecturerDto;

import java.util.List;

public interface LecturerService {
    List<LecturerDto> getAll();
    LecturerDto findById(String lecturerId);
    LecturerDto create(LecturerDto lecturerDTO);
    LecturerDto update(String lecturerId, LecturerDto lecturerDTO);
    void delete(String lecturerId);
}
