package alexsafonova.myFirstSpringBootApp.service;


import alexsafonova.myFirstSpringBootApp.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();


}
