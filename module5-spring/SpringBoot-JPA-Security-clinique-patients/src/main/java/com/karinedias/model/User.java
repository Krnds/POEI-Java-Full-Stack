package com.karinedias.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class User {
    private int id;
    private String username;
    private String email;
    private String roles;
    private String password;
    private String name;
    private String photouser;
    private String userResetpasstoken;
    private Timestamp userResetpassdate;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "roles")
    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "photouser")
    public String getPhotouser() {
        return photouser;
    }

    public void setPhotouser(String photouser) {
        this.photouser = photouser;
    }

    @Basic
    @Column(name = "user_resetpasstoken")
    public String getUserResetpasstoken() {
        return userResetpasstoken;
    }

    public void setUserResetpasstoken(String userResetpasstoken) {
        this.userResetpasstoken = userResetpasstoken;
    }

    @Basic
    @Column(name = "user_resetpassdate")
    public Timestamp getUserResetpassdate() {
        return userResetpassdate;
    }

    public void setUserResetpassdate(Timestamp userResetpassdate) {
        this.userResetpassdate = userResetpassdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(roles, user.roles) && Objects.equals(password, user.password) && Objects.equals(name, user.name) && Objects.equals(photouser, user.photouser) && Objects.equals(userResetpasstoken, user.userResetpasstoken) && Objects.equals(userResetpassdate, user.userResetpassdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, roles, password, name, photouser, userResetpasstoken, userResetpassdate);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", roles='" + roles + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", photouser='" + photouser + '\'' +
                ", userResetpasstoken='" + userResetpasstoken + '\'' +
                ", userResetpassdate=" + userResetpassdate +
                '}';
    }
}
