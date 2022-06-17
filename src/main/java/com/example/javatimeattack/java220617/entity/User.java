package com.example.javatimeattack.java220617.entity;

import com.example.javatimeattack.java220617.dto.UserRequestDto;
import com.example.javatimeattack.java220617.util.Timestamped;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Entity
@Table(name="T_users")
public class User extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private int gender;

    public User(String email, String name, int age, int gender) {
        this.email = email;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public User(UserRequestDto requestDto) {
        this.email = requestDto.getEmail();
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
    }

    public void update(UserRequestDto requestDto) {
        this.name = requestDto.getName();
        this.age = requestDto.getAge();
        this.gender = requestDto.getGender();
    }
}



