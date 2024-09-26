package ms.school.user.commons.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorResponseDto {

    private String path;
    private HttpStatus code;
    private String message;
    private LocalDateTime time;

}