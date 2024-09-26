package ms.school.study.commons.mapper;

import ms.school.study.commons.dto.LecturerDto;
import ms.school.study.commons.entity.Lecturer;

public class LecturerMapper {
    public static Lecturer toEntity(LecturerDto lecturerDto) {
        Lecturer lecturer = new Lecturer();
        lecturer.setLecturerId(lecturerDto.getLecturerId());
        lecturer.setName(lecturerDto.getName());
        lecturer.setEmail(lecturerDto.getEmail());
        lecturer.setPhoneNumber(lecturerDto.getPhoneNumber());
        lecturer.setDepartment(lecturerDto.getDepartment());
        lecturer.setOfficeAddress(lecturerDto.getOfficeAddress());
        return lecturer;
    }

    public static LecturerDto toDto(Lecturer lecturer) {
        LecturerDto lecturerDto = new LecturerDto();
        lecturerDto.setLecturerId(lecturer.getLecturerId());
        lecturerDto.setName(lecturer.getName());
        lecturerDto.setEmail(lecturer.getEmail());
        lecturerDto.setPhoneNumber(lecturer.getPhoneNumber());
        lecturerDto.setDepartment(lecturer.getDepartment());
        lecturerDto.setOfficeAddress(lecturer.getOfficeAddress());
        return lecturerDto;
    }
}
