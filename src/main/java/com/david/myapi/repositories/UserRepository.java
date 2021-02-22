package com.david.myapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.david.myapi.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
