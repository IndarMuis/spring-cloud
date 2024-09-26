package ms.school.user.service;

import ms.school.user.commons.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDto create(UserDto userDTO);

    UserDto update(Long id, UserDto userDTO);

    void delete(Long id);

    List<UserDto> getAll();

    UserDto findById(Long id);

    UserDto findByEmail(String email);
}
