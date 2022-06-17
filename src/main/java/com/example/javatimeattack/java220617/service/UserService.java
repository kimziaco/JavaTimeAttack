package com.example.javatimeattack.java220617.service;

import com.example.javatimeattack.java220617.dto.UserRequestDto;
import com.example.javatimeattack.java220617.entity.User;
import com.example.javatimeattack.java220617.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public Long update(Long id, UserRequestDto requestDto) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        user.update(requestDto);
        return user.getId();
    }
}



