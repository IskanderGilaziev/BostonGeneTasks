package ru.BostonGene.gilaziev.answers.task2_rest.dao;



import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import ru.BostonGene.gilaziev.answers.task2_rest.pojo.User;

import java.util.*;



@Repository
public class UserDAOImpl implements  UserDAO {
    private static final Logger logger = Logger.getLogger(UserDAOImpl.class);

    private static Map<String, User> allUsers = new HashMap<>();

    @Override
    public void addUser(User user) {
        logger.info("Method addUser started.");
        allUsers.put(user.getEmail(),user);
        logger.info("Method addUser finished.");

    }

    @Override
    public boolean deleteUserByEmail(String email) {
        logger.info("Method deleteUserByEmail started.");
        if(email==null){
            logger.warn("Email is null");
            return  false;
        }
        allUsers.remove(email);
        logger.info("Method deleteUserByEmail finished.");
        return true;
    }

    @Override
    public User findUserByEmail(String email) {
        logger.info("Method findUserByEmail started.");
        if(email==null){
            logger.warn("Email is null");
            return null;
        }
        logger.info("Method findUserByEmail finished.");
        return allUsers.get(email);
    }

    @Override
    public List<User> getAll(){
        logger.info("Method getAll started.");
        List<User> users = new ArrayList<>();
        for(Iterator<User> it = allUsers.values().iterator(); it.hasNext(); ) {
            User nextUser = it.next();
            users.add(nextUser);
        }
        logger.info("Method getAll finished.");
        return users;
    }
}
