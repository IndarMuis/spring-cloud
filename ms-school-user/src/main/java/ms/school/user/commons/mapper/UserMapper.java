package ms.school.user.commons.mapper;

import ms.school.user.commons.dto.RoleDto;
import ms.school.user.commons.dto.UserDto;
import ms.school.user.commons.entity.Role;
import ms.school.user.commons.entity.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserMapper {

    public static UserDto toDTO(User user) {
        if (user == null) {
            return null;
        }

        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setEmail(user.getEmail());
        userDTO.setPassword(user.getPassword());

        return userDTO;
    }

    public static User toEntity(UserDto userDTO) {
        if (userDTO == null) {
            return null;
        }

        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());

        return user;
    }

    private static Set<RoleDto> toRoleDtos(Set<Role> roles) {
        return roles.stream()
                .map(RoleMapper::toDTO)
                .collect(Collectors.toSet());
    }

    private static Set<Role> toRoles(Set<RoleDto> roleDTOs) {
        return roleDTOs.stream()
                .map(RoleMapper::toEntity)
                .collect(Collectors.toSet());
    }
}

