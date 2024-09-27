package ms.school.user.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ms.school.user.commons.dto.UserDto;
import ms.school.user.commons.entity.User;
import ms.school.user.commons.exception.ResourceNotFoundException;
import ms.school.user.commons.mapper.UserMapper;
import ms.school.user.repository.UserRepository;
import ms.school.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Transactional
public class UserServiceImpl implements UserService {


    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDto create(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        User savedUser = userRepository.save(user);
        return UserMapper.toDTO(savedUser);
    }

    @Override
    public UserDto update(Long id, UserDto userDto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        if (userDto.getPassword() != null && !userDto.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        }
        user.setUpdatedAt(LocalDateTime.now());

        User updatedUser = userRepository.save(user);
        return UserMapper.toDTO(updatedUser);
    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));
        return UserMapper.toDTO(user);
    }

    @Override
    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));
        userRepository.delete(user);
    }
}
