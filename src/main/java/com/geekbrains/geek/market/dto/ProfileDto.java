package com.geekbrains.geek.market.dto;

import com.geekbrains.geek.market.entities.Profile;
import com.geekbrains.geek.market.enums.sex;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public class ProfileDto {
    private Long id;
    private String username;
    private String email;
    private String name;
    private String surname;
    private String phone;
    private String birthyear;
    private Enum<sex> sex;
    private String city;
    private String confirmationPassword;

    public ProfileDto(Profile p) {
        this.id                     = p.getId();
        this.username               = p.getUser().getUsername();
        this.email                  = p.getEmail();
        this.name                   = p.getName();
        this.surname                = p.getSurname();
        this.phone                  = p.getPhone();
        this.birthyear              = p.getBirthyear();
        this.sex                    = p.getSex();


    }

}
