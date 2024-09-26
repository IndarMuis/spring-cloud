package ms.school.study.commons.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDto {

    private String studentId;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    private String phoneNumber;

    private LocalDate dateOfBirth;

    @NotBlank(message = "Major is mandatory")
    private String major;

    @Min(value = 1900, message = "Year of entry must be valid")
    private int yearOfEntry;

    private String address;
}