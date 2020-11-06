package com.geekbrains.geek.market.controllers;

import com.geekbrains.geek.market.dto.OrderDto;
import com.geekbrains.geek.market.entities.Order;
import com.geekbrains.geek.market.entities.Product;
import com.geekbrains.geek.market.entities.User;
import com.geekbrains.geek.market.exceptions.ResourceNotFoundException;
import com.geekbrains.geek.market.services.OrderService;
import com.geekbrains.geek.market.services.UserService;
import com.geekbrains.geek.market.utils.Cart;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/userprofile")
@RequiredArgsConstructor
public class UserProfileController {
    private final UserService userService;

    @GetMapping
    public User getUser(Principal principal) {
        return userService.findByUsername( principal.getName() ).orElseThrow(()->new ResourceNotFoundException( "Unable to create order for user:"+principal.getName()+". User doesn`t exist") );
    }





    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void updateProfile(Principal principal, @RequestBody User loadUser) {
        User user = userService.findByUsername( principal.getName() ).orElseThrow(()->new ResourceNotFoundException( "User "+principal.getName()+" doesn`t exist") );

        if (user.getPassword() == loadUser.getPassword()){
            userService.saveOrUpdate(loadUser  );
            
        }

    }

}
