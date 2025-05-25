package models;

import jakarta.persistence.*;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "number")
    private int number;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<User> userList;
    public Group(){
    }

    public Group(int number) {
        this.number = number;
        this.userList = new ArrayList<>();
    }
    public  void addUserToGroup(User user){
        if(user!=null){
            this.userList.remove(user);
            user.setGroup(this);
        }else {
            throw new IllegalArgumentException("This is not a user");
        }
    }

    public int getId() {
            return id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "userList=" + userList +
                '}';
    }
}
