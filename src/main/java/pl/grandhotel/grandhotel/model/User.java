package pl.grandhotel.grandhotel.model;

import jakarta.persistence.*;
import pl.grandhotel.grandhotel.model.types.Status;

import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "hotel")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id", nullable = false, updatable = false)
    private int userId;
    @Basic
    @Column(name = "user_name", nullable = false, length = 50)
    private String userName;
    @Basic
    @Column(name = "user_lastname", nullable = false, length = 50)
    private String userLastname;
    @Basic
    @Column(name = "user_email", nullable = false, length = 100)
    private String userEmail;
    @Basic
    @Column(name = "user_phone", nullable = true, length = 15)
    private String userPhone;
    @Basic
    @Column(name = "user_password", nullable = false, length = 50)
    private String userPassword;
    @Enumerated(EnumType.STRING)
    @Column(name = "user_status", nullable = false)
    private Status userStatus;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Status getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Status userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return userId == user.userId && Objects.equals(userName, user.userName) && Objects.equals(userLastname, user.userLastname) && Objects.equals(userEmail, user.userEmail) && Objects.equals(userPhone, user.userPhone) && Objects.equals(userPassword, user.userPassword) && Objects.equals(userStatus, user.userStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName, userLastname, userEmail, userPhone, userPassword, userStatus);
    }

}
