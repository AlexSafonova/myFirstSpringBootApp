package alexsafonova.myFirstSpringBootApp.service;

import alexsafonova.myFirstSpringBootApp.model.User;
import alexsafonova.myFirstSpringBootApp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userRepository.addUser(user);

    }

    @Transactional
    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);

    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);

    }

    @Transactional(readOnly = true)
    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

}

