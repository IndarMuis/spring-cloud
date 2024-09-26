package ms.school.study.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDto {

    private String courseId;

    @NotBlank(message = "Course name is mandatory")
    private String courseName;

    @Min(value = 1, message = "Credits must be at least 1")
    private int credits;

    @Min(value = 1, message = "Semester must be at least 1")
    private int semester;

    @NotBlank(message = "Department is mandatory")
    private String department;

    private String description;
}
