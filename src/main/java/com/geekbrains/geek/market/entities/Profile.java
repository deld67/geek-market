package com.geekbrains.geek.market.entities;

import com.geekbrains.geek.market.enums.sex;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birthyear")
    private String birthyear;

    @Column(name = "sex")
    private Enum<sex> sex;

    @Column(name = "city")
    private String city;


}