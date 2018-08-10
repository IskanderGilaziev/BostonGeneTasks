package ru.BostonGene.gilaziev.answers.task2_rest.dao;



import org.springframework.stereotype.Repository;
import ru.BostonGene.gilaziev.answers.task2_rest.pojo.User;

import java.util.List;
import java.util.Optional;


public interface UserDAO  {

    void addUser(User user);
    boolean deleteUserByEmail(String email);
    User findUserByEmail(String email);
    List<User> getAll();
}
