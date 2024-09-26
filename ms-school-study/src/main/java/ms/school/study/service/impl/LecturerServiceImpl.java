package ms.school.study.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ms.school.study.commons.dto.LecturerDto;
import ms.school.study.commons.entity.Lecturer;
import ms.school.study.commons.exception.ResourceNotFoundException;
import ms.school.study.commons.mapper.LecturerMapper;
import ms.school.study.repository.LecturerRepository;
import ms.school.study.service.LecturerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    @Override
    public List<LecturerDto> getAll() {
        return lecturerRepository.findAll().stream()
                .map(LecturerMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public LecturerDto findById(String lecturerId) {
        return LecturerMapper.toDto(lecturerRepository.findById(lecturerId)
               .orElseThrow(() -> new ResourceNotFoundException("Lecturer", "lecturerId", lecturerId)));
    }

    @Override
    @Transactional
    public LecturerDto create(LecturerDto lecturerDTO) {
        Lecturer lecturer = LecturerMapper.toEntity(lecturerDTO);
        return LecturerMapper.toDto(lecturerRepository.save(lecturer));
    }

    @Override
    @Transactional
    public LecturerDto update(String lecturerId, LecturerDto lecturerDTO) {
        Lecturer existingLecturer = lecturerRepository.findById(lecturerId)
               .orElseThrow(() -> new ResourceNotFoundException("Lecturer", "lecturerId", lecturerId));
        existingLecturer.setName(lecturerDTO.getName());
        existingLecturer.setEmail(lecturerDTO.getEmail());
        existingLecturer.setPhoneNumber(lecturerDTO.getPhoneNumber());
        existingLecturer.setDepartment(lecturerDTO.getDepartment());
        existingLecturer.setOfficeAddress(lecturerDTO.getOfficeAddress());
        return LecturerMapper.toDto(lecturerRepository.save(existingLecturer));
    }

    @Override
    @Transactional
    public void delete(String lecturerId) {
        Lecturer lecturer = lecturerRepository.findById(lecturerId)
               .orElseThrow(() -> new ResourceNotFoundException("Lecturer", "lecturerId", lecturerId));
        lecturerRepository.delete(lecturer);
    }

}
