package com.assignement.app.REST.API.Repository;

import com.assignement.app.REST.API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
