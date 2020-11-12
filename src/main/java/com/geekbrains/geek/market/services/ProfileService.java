package com.geekbrains.geek.market.services;

import com.geekbrains.geek.market.dto.OrderDto;
import com.geekbrains.geek.market.entities.Order;
import com.geekbrains.geek.market.entities.Profile;
import com.geekbrains.geek.market.repositories.OrderRepository;
import com.geekbrains.geek.market.repositories.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Optional<Profile> findById(Long id) {
        return profileRepository.findById(id);
    }
    public Optional<Profile> findByUserName(String username) {

        return profileRepository.findByUsername( username );
    }

    public Profile saveOrUpdate(Profile profile) {
        return profileRepository.save(profile);
    }
}
