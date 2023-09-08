package pl.przepisy.Projekt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.przepisy.Projekt.entity.user;
import pl.przepisy.Projekt.repository.UserRepository;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public user create(user user) {
        return userRepository.save(user);
    }
    public user update(user user) {
        user existingUser = userRepository.findById(user.getId()).orElse(null);
        if (existingUser == null) {
            throw new IllegalArgumentException("User with ID " + user.getId() + " not found.");
        }
        user userToUpdate = existingUser;
        userToUpdate.setLogin(user.getLogin());
        userToUpdate.setPassword(user.getPassword());
        userToUpdate.setEmail(user.getEmail());
        return userRepository.save(userToUpdate);
    }
    public user findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
    public user save(user user) {
        return userRepository.save(user);
    }
    public user findByLogin(String login) {
        return userRepository.findByLogin(login);
    }
}
