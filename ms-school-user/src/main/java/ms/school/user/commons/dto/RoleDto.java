package ms.school.user.commons.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private Long id;

    @NotNull(message = "Role name cannot be null")
    @Size(min = 1, max = 50, message = "Role name must be between 1 and 50 characters")
    private String roleName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
