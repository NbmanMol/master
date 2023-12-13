package web.dao;


import web.model.User;

import java.util.List;

public interface UserDao {
    void createUser(User user);
    List<User> getUsersList();
    void deleteUser(User user);

    User getUserForId(int id);

    void updateUser(Integer id );
}