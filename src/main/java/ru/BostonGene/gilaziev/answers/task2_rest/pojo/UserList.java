package ru.BostonGene.gilaziev.answers.task2_rest.pojo;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class UserList {

    private List<User> userList;

    public UserList() {
    }

    public UserList(List<User> userList) {
        this.userList = userList;
    }

 @XmlElement
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
