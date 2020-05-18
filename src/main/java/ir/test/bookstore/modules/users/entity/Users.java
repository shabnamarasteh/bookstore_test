package ir.test.bookstore.modules.users.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.test.bookstore.modules.admins.entity.Admins;
import ir.test.bookstore.modules.levels.entity.Levels;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Users {
    @Id
    @GeneratedValue
    private long id;
    private String firstname;
    private String lastname;
    private long nationalcode;
    @Column(unique = true)
    private String email;
    private String password;
    private String address;
    private LocalDateTime lastlogin;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    private long phonenumber;
    private long mobilenumber;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private Admins createdBy;

    @ManyToOne
    private Levels level;

    public Users() {
    }

    public Users(String firstname, String lastname, long nationalcode, String email, String password, String address, long phonenumber, long mobilenumber) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalcode = nationalcode;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.mobilenumber = mobilenumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getNationalcode() {
        return nationalcode;
    }

    public void setNationalcode(long nationalcode) {
        this.nationalcode = nationalcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getLastlogin() {
        return lastlogin;
    }

    public void setLastlogin(LocalDateTime lastlogin) {
        this.lastlogin = lastlogin;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }


    public long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public long getMobilenumber() {
        return mobilenumber;
    }

    public void setMobilenumber(long mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public Admins getCreatedBy() {
        return createdBy;
    }

    public Users setCreatedBy(Admins createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Levels getLevel() {
        return level;
    }

    public Users setLevel(Levels level) {
        this.level = level;
        return this;
    }
}
