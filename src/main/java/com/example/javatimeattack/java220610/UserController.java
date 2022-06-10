package com.example.javatimeattack.java220610;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;


    @PostMapping("/api/users")
    public User createUser(@RequestBody UserRequestDto requestDto) {
        User user = new User(requestDto);
        return userRepository.save(user);
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{id}")
    public List<User> recommendUsers() {
        return userRepository.findAllByOrderByModifiedAtDesc();
    }

    @PutMapping("/api/users/{id}")
    public Long updateUser(@PathVariable Long id, @RequestBody UserRequestDto requestDto) {
        return userService.update(id, requestDto);
    }

    @DeleteMapping("api/users/{id}")
    public Long deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
        return id;
    }

}
