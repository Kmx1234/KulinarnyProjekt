package pl.przepisy.Projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.przepisy.Projekt.entity.user;

public interface UserRepository extends JpaRepository<user, Long> {
    user findByLogin(String login);
}
