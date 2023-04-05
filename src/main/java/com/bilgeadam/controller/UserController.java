package com.bilgeadam.controller;

import com.bilgeadam.dto.request.UserRegisterRequestDto;
import com.bilgeadam.dto.request.UserUpdateRequestDto;
import com.bilgeadam.dto.response.UserLoginResponseDto;
import com.bilgeadam.entity.User;
import com.bilgeadam.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

import static com.bilgeadam.constant.EndPointList.*;

@RestController
@RequestMapping(USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping(REGISTER)
    public ResponseEntity<User> register(String name,String surname,String email,String password,String repassword){
        return ResponseEntity.ok(userService.register(name, surname, email, password, repassword));
    }

    @PostMapping(REGISTER_DTO)
    public ResponseEntity<UserRegisterRequestDto> registerDto(@RequestBody UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerDto(dto));
    }

    @PostMapping(REGISTER_MAPPER)
    public ResponseEntity<UserRegisterRequestDto> registerMapper(@RequestBody @Valid UserRegisterRequestDto dto){
        return ResponseEntity.ok(userService.registerMapper(dto));
    }
    @PostMapping(LOGIN)
    public ResponseEntity<String> login(String email, String password){
        return ResponseEntity.ok(userService.login(email, password));
    }
    @PostMapping(LOGIN_DTO)
    public ResponseEntity<String> loginDto(@RequestBody UserLoginResponseDto dto){
        return ResponseEntity.ok(userService.loginDto(dto));
    }
    @PostMapping(LOGIN_MAPPER)
    public ResponseEntity<UserLoginResponseDto> loginMapper(@RequestBody UserLoginResponseDto dto){
        return ResponseEntity.ok(userService.loginMapper(dto));
    }

    @PostMapping(CUSTOM_LOGIN)
    public ResponseEntity customLogin(@RequestBody UserLoginResponseDto dto){
        return userService.customLogin(dto);
    }

    @GetMapping(FIND_ALL)
    public ResponseEntity<List<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping(FIND_BY_ID)
    public ResponseEntity<Optional<User>> findById(Integer id){
        return ResponseEntity.ok(userService.findById(id));
    }

    @PutMapping(UPDATE_DTO)
    public ResponseEntity<User> updateDto(UserUpdateRequestDto dto){
        return ResponseEntity.ok(userService.updateDto(dto));
    }

    @PutMapping(UPDATE_MAPPER)
    public ResponseEntity<User> updateMapper(UserUpdateRequestDto dto){
        return ResponseEntity.ok(userService.updateMapper(dto));
    }
    @DeleteMapping(DELETE + "/{id}")
    public ResponseEntity<User> delete(@PathVariable Integer id){
        return ResponseEntity.ok(userService.delete(id));
    }

    @GetMapping(FIND_BY_ORDER_BY_NAME)
    public ResponseEntity<List<User>> findByOrderByName(){
        return ResponseEntity.ok(userService.findByOrderByName());
    }

    @GetMapping(FIND_BY_NAME_CONTAINS)
    public ResponseEntity<List<User>> findAllByNameContainsIgnoreCase(String value){
        return ResponseEntity.ok(userService.findAllByNameContainsIgnoreCase(value));
    }

    @GetMapping(EXISTS_NAME)
    public ResponseEntity<Boolean> existsByNameIgnoreCase(String value){
        return ResponseEntity.ok(userService.existsByNameIgnoreCase(value));
    }

    @GetMapping(FIND_BY_EMAIL)
    public ResponseEntity<List<User>> findByEmailIgnoreCase(String email){
        return ResponseEntity.ok(userService.findByEmailIgnoreCase(email));
    }

    @GetMapping(FIND_PASSWORD_GREATER_THAN_JPQL)
    public ResponseEntity<List<User>> passwordLongerThan(int num){
        return ResponseEntity.ok(userService.passwordLongerThan(num));
    }

    @GetMapping(FIND_PASSWORD_GREATER_THAN_NATIVE)
    public ResponseEntity<List<User>> passwordLongerThan2(int num){
        return ResponseEntity.ok(userService.passwordLongerThan2(num));
    }

    @GetMapping( FIND_EMAIL_ENDS_WITH)
    public ResponseEntity<List<User>> findByEmailEndsWithIgnoreCase(String email){
        return ResponseEntity.ok(userService.findByEmailEndsWithIgnoreCase(email));
    }
}
