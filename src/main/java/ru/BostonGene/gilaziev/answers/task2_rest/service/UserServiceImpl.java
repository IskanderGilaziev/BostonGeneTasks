package ru.BostonGene.gilaziev.answers.task2_rest.service;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.BostonGene.gilaziev.answers.task2_rest.dao.UserDAO;
import ru.BostonGene.gilaziev.answers.task2_rest.pojo.User;

import java.util.List;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    UserDAO userDAO;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDAO userDAO) {

    }


    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public boolean deleteUserByEmail(String email) {
        userDAO.deleteUserByEmail(email);
        return true;
    }

    @Override
    public User findUserByEmail(String email) {
        return userDAO.findUserByEmail(email);

    }

    @Override
    public List<User> getAll(){
        return userDAO.getAll();
    }
}
