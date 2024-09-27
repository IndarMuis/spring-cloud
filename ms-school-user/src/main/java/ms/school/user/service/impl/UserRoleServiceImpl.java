package ms.school.user.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ms.school.user.commons.dto.RoleDto;
import ms.school.user.commons.dto.UserDto;
import ms.school.user.commons.dto.UserRoleDto;
import ms.school.user.commons.entity.Role;
import ms.school.user.commons.entity.User;
import ms.school.user.commons.entity.UserRole;
import ms.school.user.commons.exception.ResourceNotFoundException;
import ms.school.user.repository.RoleRepository;
import ms.school.user.repository.UserRepository;
import ms.school.user.repository.UserRoleRepository;
import ms.school.user.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public UserRoleDto assignRoleToUser(UserRoleDto userRoleDto) {

        User user = userRepository.findById(userRoleDto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userRoleDto.getUser().getId().toString()));
        Role role = roleRepository.findById(userRoleDto.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Role", "roleId", userRoleDto.getRole().getId().toString()));

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());
        userRole.setAssignedAt(LocalDateTime.now());

        UserRole savedUserRole = userRoleRepository.save(userRole);
        return convertToDto(savedUserRole);
    }

    @Override
    public UserRoleDto updateUserRole(Long id, UserRoleDto userRoleDto) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole", "userRoleId", id.toString()));

        // Validasi apakah user dan role ada di database
        User user = userRepository.findById(userRoleDto.getUser().getId())
                .orElseThrow(() -> new ResourceNotFoundException("User", "userId", userRoleDto.getUser().getId().toString()));
        Role role = roleRepository.findById(userRoleDto.getRole().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Role", "roleId", userRoleDto.getRole().getId().toString()));

        userRole.setUserId(user.getId());
        userRole.setRoleId(role.getId());

        UserRole updatedUserRole = userRoleRepository.save(userRole);
        return convertToDto(updatedUserRole);
    }

    @Override
    public UserRoleDto getUserRoleById(Long id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole", "userRoleId", id.toString()));
        return convertToDto(userRole);
    }

    @Override
    public void deleteUserRole(Long id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole", "userRoleId", id.toString()));
        userRoleRepository.delete(userRole);
    }

    private UserRoleDto convertToDto(UserRole userRole) {
        UserDto userDto = new UserDto();
        userDto.setId(userRole.getUserId());

        RoleDto roleDto = new RoleDto();
        roleDto.setId(userRole.getRoleId());

        return UserRoleDto.builder()
                .id(userRole.getId())
                .user(userDto)
                .role(roleDto)
                .assignedAt(userRole.getAssignedAt())
                .build();
    }
}
