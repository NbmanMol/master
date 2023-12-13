package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.dao.UserDao;
import web.model.User;

import  org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Transactional(readOnly = true)
@Service
public class UserServiceImp implements UserService {
    private final UserDao userDao;

    @Autowired
    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUserList() {
        return userDao.getUsersList();
    }
    @Override
    public User getUserForId(int id) {
        return userDao.getUserForId(id);
    }

    @Transactional
    @Override
    public void updateUser(Integer id ) {
        userDao.updateUser(id);
    }

    @Transactional
    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Transactional
    @Override
    public void createUser(User user) {
        userDao.createUser(user);
    }
}