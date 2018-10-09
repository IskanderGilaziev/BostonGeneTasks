package ru.BostonGene.gilaziev.answers.task2_rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.BostonGene.gilaziev.answers.task2_rest.pojo.User;
import ru.BostonGene.gilaziev.answers.task2_rest.pojo.UserList;
import ru.BostonGene.gilaziev.answers.task2_rest.service.UserService;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;

import java.sql.Date;
import java.util.List;


@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    Jaxb2Marshaller jaxb2Marshaller;

    @RequestMapping(value = "/getUser/{email}", method = RequestMethod.GET,
                                                headers="content-type=application/xml, application/json")
    public @ResponseBody User getUserByEmail(@PathVariable String email){
        User users = userService.findUserByEmail(email);
        return  users;
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public @ResponseBody User addUser(@RequestBody String requestUser){
        Source source = new StreamSource(new StringReader(requestUser));
        User addUser = (User) jaxb2Marshaller.unmarshal(source);
        userService.addUser(addUser);
        return  addUser;
    }

    @RequestMapping(value = "/deleteUser/{email}",method = RequestMethod.DELETE)
    @ResponseBody
    public  void  deleteUser(@PathVariable String email){
        userService.deleteUserByEmail(email);
    }

    @RequestMapping(value = "/getUserAll", method = RequestMethod.GET,
                                            headers="content-type=application/xml, application/json")
    @ResponseBody
    public UserList getUserAll(){
        List<User>listUser = userService.getAll();
        UserList userList = new UserList(listUser);
        return  userList;
    }
}
