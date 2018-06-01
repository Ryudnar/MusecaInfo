package com.ryudnar.MusecaInfo.domain.Entity;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Table(name = "user_data")
@Getter
@Entity
public class UserDataEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;

    @Column(name = "user_name", length = 30, nullable = false)
    private String UserName;

    @Column(name = "user_email", length = 50, nullable = false)
    private String UserEmail;

    @Builder
    public UserDataEntity(String UserName, String UserEmail) {
        this.UserName = UserName;
        this.UserEmail = UserEmail;
    }
}