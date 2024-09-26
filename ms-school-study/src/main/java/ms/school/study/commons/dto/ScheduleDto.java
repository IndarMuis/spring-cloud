package ms.school.study.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ms.school.study.commons.enums.DayOfWeek;

import java.time.LocalTime;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ScheduleDto {

    private Long scheduleId;

    @NotBlank(message = "Course ID is mandatory")
    private String courseId;

    @NotBlank(message = "Lecturer ID is mandatory")
    private String lecturerId;

    @NotNull(message = "Day is mandatory")
    private DayOfWeek day;

    @NotNull(message = "Start time is mandatory")
    private LocalTime timeStart;

    @NotNull(message = "End time is mandatory")
    private LocalTime timeEnd;

    @NotBlank(message = "Room is mandatory")
    private String room;

    @Min(value = 1, message = "Semester must be at least 1")
    private int semester;

    @Min(value = 0, message = "Class capacity must be at least 0")
    private int classCapacity;
}
