package ms.school.user.commons.mapper;

import ms.school.user.commons.dto.RoleDto;
import ms.school.user.commons.entity.Role;

public class RoleMapper {

    public static RoleDto toDTO(Role role) {
        if (role == null) {
            return null;
        }

        RoleDto roleDTO = new RoleDto();
        roleDTO.setId(role.getId());
        roleDTO.setRoleName(role.getRoleName());
        roleDTO.setCreatedAt(role.getCreatedAt());
        roleDTO.setUpdatedAt(role.getUpdatedAt());

        return roleDTO;
    }

    public static Role toEntity(RoleDto roleDTO) {
        if (roleDTO == null) {
            return null;
        }

        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setRoleName(roleDTO.getRoleName());
        role.setCreatedAt(roleDTO.getCreatedAt());
        role.setUpdatedAt(roleDTO.getUpdatedAt());

        return role;
    }
}