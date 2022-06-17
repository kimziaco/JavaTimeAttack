package com.example.javatimeattack.java220617.util;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Timestamped {

    @CreatedDate //생성시간을 나타냄
    private LocalDateTime createdAt;

    @LastModifiedDate //수정시간을 나타냄
    private LocalDateTime modifiedAt;
}
