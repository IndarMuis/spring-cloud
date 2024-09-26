package ms.school.study.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import ms.school.study.commons.enums.EnrollmentStatus;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentEnrollmentDto {

    private Long enrollmentId;

    @NotBlank(message = "Student ID is mandatory")
    private String studentId;

    @NotNull(message = "Schedule ID is mandatory")
    private Long scheduleId;

    @NotNull(message = "Enrollment date is mandatory")
    @FutureOrPresent(message = "Enrollment date must be today or in the future")
    private LocalDate enrollmentDate;

    @NotNull(message = "Status is mandatory")
    private EnrollmentStatus status;
}
