package ms.school.user.service;

import ms.school.user.commons.dto.UserDto;

public interface UserService {
    UserDto create(UserDto userDto);
    UserDto update(Long id, UserDto userDto);
    UserDto findById(Long id);
    void delete(Long id);
}
