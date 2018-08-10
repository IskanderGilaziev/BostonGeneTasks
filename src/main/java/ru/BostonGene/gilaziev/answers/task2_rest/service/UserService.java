package ru.BostonGene.gilaziev.answers.task2_rest.service;


import ru.BostonGene.gilaziev.answers.task2_rest.pojo.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    boolean deleteUserByEmail(String email);
    User findUserByEmail(String email);
    List<User> getAll();
}
