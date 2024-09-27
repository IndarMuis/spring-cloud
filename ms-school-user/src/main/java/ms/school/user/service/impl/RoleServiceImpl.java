package ms.school.user.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import ms.school.user.commons.dto.RoleDto;
import ms.school.user.commons.entity.Role;
import ms.school.user.commons.exception.ResourceNotFoundException;
import ms.school.user.commons.mapper.RoleMapper;
import ms.school.user.repository.RoleRepository;
import ms.school.user.service.RoleService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleDto create(RoleDto roleDto) {
        Role role = RoleMapper.toEntity(roleDto);
        role.setCreatedAt(LocalDateTime.now());
        role.setUpdatedAt(LocalDateTime.now());
        Role newRole = roleRepository.save(role);
        return RoleMapper.toDTO(newRole);
    }

    @Override
    public RoleDto update(Long id, RoleDto roleDto) {
        Role existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id.toString()));
        existingRole.setRoleName(roleDto.getRoleName());
        existingRole.setUpdatedAt(LocalDateTime.now());
        Role updatedRole = roleRepository.save(existingRole);
        return RoleMapper.toDTO(updatedRole);
    }

    @Override
    public RoleDto findById(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id.toString()));
        return RoleMapper.toDTO(role);
    }

    @Override
    public void delete(Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Role", "id", id.toString()));
        roleRepository.delete(role);
    }
}
