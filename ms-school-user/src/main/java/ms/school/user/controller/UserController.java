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

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/user/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseDto<UserDto>> createUser(@Valid @RequestBody UserDto userDto) {
        UserDto createdUser = userService.create(userDto);
        return new ResponseEntity<>(new ResponseDto<>("201", "Created", createdUser), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseDto<UserDto>> updateUser(@PathVariable Long id, @Valid @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.update(id, userDto);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", updatedUser), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<UserDto>> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.findById(id);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDto<Void>> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(new ResponseDto<>("200", "OK", null), HttpStatus.OK);
    }
}
