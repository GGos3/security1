package xyz.ggos3.security1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ggos3.security1.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
