package ms.school.study.commons.mapper;

import ms.school.study.commons.dto.ScheduleDto;
import ms.school.study.commons.entity.Schedule;

public class ScheduleMapper {
    public static Schedule toEntity(ScheduleDto scheduleDto) {

        Schedule schedule = new Schedule();
        schedule.setScheduleId(scheduleDto.getScheduleId());
        schedule.setCourseId(scheduleDto.getCourseId());
        schedule.setLecturerId(scheduleDto.getLecturerId());
        schedule.setDay(scheduleDto.getDay());
        schedule.setTimeStart(scheduleDto.getTimeStart());
        schedule.setTimeEnd(scheduleDto.getTimeEnd());
        schedule.setRoom(scheduleDto.getRoom());
        schedule.setSemester(scheduleDto.getSemester());
        schedule.setClassCapacity(scheduleDto.getClassCapacity());
        return schedule;
    }

    public static ScheduleDto toDTO(Schedule schedule) {

        ScheduleDto scheduleDto = new ScheduleDto();
        scheduleDto.setScheduleId(schedule.getScheduleId());
        scheduleDto.setCourseId(schedule.getCourseId());
        scheduleDto.setLecturerId(schedule.getLecturerId());
        scheduleDto.setDay(schedule.getDay());
        scheduleDto.setTimeStart(schedule.getTimeStart());
        scheduleDto.setTimeEnd(schedule.getTimeEnd());
        scheduleDto.setRoom(schedule.getRoom());
        scheduleDto.setSemester(schedule.getSemester());
        scheduleDto.setClassCapacity(schedule.getClassCapacity());
        return scheduleDto;
    }
}
