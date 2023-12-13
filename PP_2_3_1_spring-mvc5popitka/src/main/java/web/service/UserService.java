package web.service;

import web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    User getUserForId(int id);

    void updateUser(Integer id);

    void deleteUser(User user);
    void createUser(User user);
}