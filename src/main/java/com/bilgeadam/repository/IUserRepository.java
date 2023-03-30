package com.bilgeadam.repository;


import com.bilgeadam.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);

    /**
     * önce büyük sonra küçük harfler sıralanıyor, kontrol edilecek
     */
    List<User> findAllByOrderByName();

    List<User> findAllByNameContainsIgnoreCase(String value);

    boolean existsByNameIgnoreCase(String value);

    List<User> findByEmailIgnoreCase(String email);

    Optional<User> findByEmailEqualsIgnoreCase(String email);


}
