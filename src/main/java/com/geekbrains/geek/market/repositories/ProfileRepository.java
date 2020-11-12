package com.geekbrains.geek.market.repositories;

import com.geekbrains.geek.market.entities.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("select o from Order o where o.user.username = ?1 ")
    Optional<Profile> findByUsername(String username);
}
