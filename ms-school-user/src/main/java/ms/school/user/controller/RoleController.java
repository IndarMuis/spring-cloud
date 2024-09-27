package ms.school.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ms.school.user.commons.dto.ResponseDto;
import ms.school.user.commons.dto.RoleDto;
import ms.school.user.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/user/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public ResponseEntity<ResponseDto<RoleDto>> createRole(@Valid @RequestBody RoleDto roleDto) {
        RoleDto createdRole = roleService.create(roleDto);
        return new ResponseEntity<>(new ResponseDto<>("201", "Created", createdRole), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<RoleDto>> updateRole(@PathVariable Long id, @Valid @RequestBody RoleDto roleDto) {
        RoleDto updatedRole = roleService.update(id, roleDto);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", updatedRole), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<RoleDto>> getRoleById(@PathVariable Long id) {
        RoleDto roleDto = roleService.findById(id);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", roleDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteRole(@PathVariable Long id) {
        roleService.delete(id);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", null), HttpStatus.OK);
    }
}