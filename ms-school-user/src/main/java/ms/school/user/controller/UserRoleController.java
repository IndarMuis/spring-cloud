package ms.school.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ms.school.user.commons.dto.ResponseDto;
import ms.school.user.commons.dto.UserRoleDto;
import ms.school.user.service.UserRoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping("/api/v1/user/user_roles")
@RequiredArgsConstructor
public class UserRoleController {

    private final UserRoleService userRoleService;

    @PostMapping
    public ResponseEntity<ResponseDto<UserRoleDto>> assignRoleToUser(@Valid @RequestBody UserRoleDto userRoleDto) {
        UserRoleDto createdUserRole = userRoleService.assignRoleToUser(userRoleDto);
        return new ResponseEntity<>(new ResponseDto<>("201", "Created", createdUserRole), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<UserRoleDto>> updateUserRole(@PathVariable Long id, @Valid @RequestBody UserRoleDto userRoleDto) {
        UserRoleDto updatedUserRole = userRoleService.updateUserRole(id, userRoleDto);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", updatedUserRole), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<UserRoleDto>> getUserRoleById(@PathVariable Long id) {
        UserRoleDto userRoleDto = userRoleService.getUserRoleById(id);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", userRoleDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteUserRole(@PathVariable Long id) {
        userRoleService.deleteUserRole(id);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", null), HttpStatus.OK);
    }
}
