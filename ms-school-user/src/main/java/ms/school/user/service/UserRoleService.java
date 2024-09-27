package ms.school.user.service;

import ms.school.user.commons.dto.UserRoleDto;

public interface UserRoleService {
    UserRoleDto assignRoleToUser(UserRoleDto userRoleDto);
    UserRoleDto updateUserRole(Long id, UserRoleDto userRoleDto);
    UserRoleDto getUserRoleById(Long id);
    void deleteUserRole(Long id);
}
