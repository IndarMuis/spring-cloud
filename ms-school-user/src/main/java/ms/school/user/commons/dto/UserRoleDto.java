package ms.school.user.commons.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserRoleDto {
    private Long id;

    @NotNull(message = "User cannot be null")
    private UserDto user;

    @NotNull(message = "Role cannot be null")
    private RoleDto role;

    private LocalDateTime assignedAt;
}
