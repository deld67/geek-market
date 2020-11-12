package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.dto.ProfileDto;
import com.geekbrains.geek.market.entities.Profile;
import com.geekbrains.geek.market.entities.User;
import com.geekbrains.geek.market.exceptions.MarketError;
import com.geekbrains.geek.market.exceptions.ResourceNotFoundException;
import com.geekbrains.geek.market.services.ProfileService;
import com.geekbrains.geek.market.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {
    private final UserService userService;
    private final ProfileService profileService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping(produces = "application/json")
    public ProfileDto getCurrentProfile (Principal principal) {
        Profile p = profileService.findByUserName( principal.getName() ).orElseThrow(() -> new ResourceNotFoundException("Unable to find profile for current user"));
        return new ProfileDto( p );
    }





    @PostMapping( produces = "application/json")
    public ResponseEntity<?> updateProfile(Principal principal, @RequestBody ProfileDto profileDto) {
        User user = userService.findByUsername( principal.getName() ).orElseThrow(()->new ResourceNotFoundException( "User "+principal.getName()+" doesn`t exist") );

        if (profileDto.getConfirmationPassword() == null || !passwordEncoder.matches(profileDto.getConfirmationPassword(), user.getPassword())) {
            return new ResponseEntity<>(new MarketError(HttpStatus.BAD_REQUEST.value(), "Incorrect password"), HttpStatus.BAD_REQUEST);
        }

        Profile p = profileService.findById(profileDto.getId()).orElseThrow(() -> new ResourceNotFoundException("Unable to find profile for current user"));
        p.setEmail (profileDto.getEmail());
        p.setName(profileDto.getName());
        p.setSurname(profileDto.getSurname());
        p.setPhone(profileDto.getPhone());
        p.setBirthyear(profileDto.getBirthyear());
        p.setSex(profileDto.getSex());
        profileService.saveOrUpdate(p);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}
