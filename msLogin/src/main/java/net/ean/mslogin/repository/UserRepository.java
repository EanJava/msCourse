package net.ean.mslogin.repository;

import net.ean.mslogin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
