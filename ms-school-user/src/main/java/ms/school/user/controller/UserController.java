package ms.school.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import ms.school.user.commons.dto.ResponseDto;
import ms.school.user.commons.dto.UserDto;
import ms.school.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/user/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto<UserDto>> create(@Valid @RequestBody UserDto userDTO) {
        UserDto createdUser = userService.create(userDTO);
        return new ResponseEntity<>(
                new ResponseDto<>("201", "Created", createdUser),
                HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<UserDto>> update(@PathVariable Long id, @Valid @RequestBody UserDto userDTO) {
        UserDto updatedUser = userService.update(id, userDTO);
        return new ResponseEntity<>(
                new ResponseDto<>("200", "OK", updatedUser),
                HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> delete(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(
                new ResponseDto<>("204", "Deleted", null),
                HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<UserDto>> findById(@PathVariable Long id) {
        UserDto user = userService.findById(id);
        return new ResponseEntity<>(
                new ResponseDto<>("200", "OK", user),
                HttpStatus.OK);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseDto<UserDto>> findByEmail(@PathVariable String email) {
        UserDto user = userService.findByEmail(email);
        return new ResponseEntity<>(
                new ResponseDto<>("200", "OK", user),
                HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<UserDto>>> getAll() {
        List<UserDto> users = userService.getAll();
        return new ResponseEntity<>(
                new ResponseDto<>("200", "OK", users),
                HttpStatus.OK);
    }
}
