package ms.school.user.service.impl;

import lombok.RequiredArgsConstructor;
import ms.school.user.commons.dto.UserDto;
import ms.school.user.commons.entity.User;
import ms.school.user.commons.exception.ResourceNotFoundException;
import ms.school.user.commons.mapper.UserMapper;
import ms.school.user.repository.UserRepository;
import ms.school.user.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public UserDto create(UserDto userDTO) {
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        User user = UserMapper.toEntity(userDTO);
        user = userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    @Override
    @Transactional
    public UserDto update(Long id, UserDto userDTO) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user = userRepository.save(user);
        return UserMapper.toDTO(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserDto> getAll() {
        return userRepository.findAll().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto findById(Long id) {
        return userRepository.findById(id).map(UserMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", id.toString()));
    }

    @Override
    public UserDto findByEmail(String email) {
        return userRepository.findByEmail(email).map(UserMapper::toDTO)
                .orElseThrow(() -> new ResourceNotFoundException("User", "email", email));
    }
}
