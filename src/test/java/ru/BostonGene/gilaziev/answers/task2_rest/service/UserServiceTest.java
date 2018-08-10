package ru.BostonGene.gilaziev.answers.task2_rest.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.BostonGene.gilaziev.answers.task2_rest.dao.UserDAOImpl;
import ru.BostonGene.gilaziev.answers.task2_rest.pojo.User;
import ru.BostonGene.gilaziev.answers.task2_rest.pojo.UserList;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(UserServiceImpl.class)
public class UserServiceTest {


    private User user;
    private List<User> list;
    private  UserDAOImpl userDAOMock;
    private  UserList userList;
    private  UserServiceImpl userService;
    private  BCryptPasswordEncoder bCryptPasswordEncoder;

    @Before
    public  void init() throws IllegalAccessException {
        user = new User(1L,"Katty","Jonson","1993-07-07","katty.com","123");
        userDAOMock = PowerMockito.mock(UserDAOImpl.class);
        userService = new UserServiceImpl(userDAOMock);
        Field fields = PowerMockito.field(UserServiceImpl.class,"userDAO");
        fields.set(userService, userDAOMock);
        list = new ArrayList<>();
        list.add(user);
        userList = new UserList(list);
        bCryptPasswordEncoder = PowerMockito.mock(BCryptPasswordEncoder.class);
    }

    @Test
    public  void getUser(){
        PowerMockito.when(userDAOMock.findUserByEmail("")).thenReturn(user);
        assertEquals(userService.findUserByEmail("katty.com"),user);
    }

    @Test
    public  void deleteUser(){
        PowerMockito.when(userDAOMock.deleteUserByEmail("katty.com")).thenReturn(true);
        assertTrue(userService.deleteUserByEmail("katty.com"));
    }

    @Test
    public  void getAllUser(){
        PowerMockito.when(userDAOMock.getAll()).thenReturn(list);
        assertEquals(userService.getAll(),list);
        assertEquals(userService.getAll(),userList.getUserList());
    }
    @Test
    public  void bcryptNewPassword(){
        PowerMockito.when(userDAOMock.findUserByEmail("katty.com")).thenReturn(user);
        String bcryptPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(bcryptPassword);
        assertEquals(bcryptPassword,user.getPassword());
    }
}
