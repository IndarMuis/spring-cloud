package ms.school.user.service;

import ms.school.user.commons.dto.RoleDto;

public interface RoleService {
    RoleDto create(RoleDto roleDto);

    RoleDto update(Long id, RoleDto roleDto);

    RoleDto findById(Long id);

    void delete(Long id);
}