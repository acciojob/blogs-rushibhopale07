package com.driver.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int Id;
    private String username;
    private String password;
    private String firstname="test";
    private String lastname="test";

    @OneToMany(mappedBy="user",cascade=CascadeType.ALL)
    List<Blog> blogList;
    public User() {
    }

    public User(int Id, String username, String password, String firstname, String lastname, List<Blog> blogList) {
        this.Id = Id;
        this.username = username;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.blogList = blogList;
    }

    public int getId() {
        return Id;
    }

    public void setId(int userId) {
        this.Id = Id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Blog> getBlogs() {
        return blogList;
    }

    public void setBlogs(List<Blog> blogList) {
        this.blogList = blogList;
    }
}

