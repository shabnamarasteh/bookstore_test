package ir.test.bookstore.modules.admins.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ir.test.bookstore.modules.books.entity.Books;
import ir.test.bookstore.modules.borrow.entity.Borrow;
import ir.test.bookstore.modules.levels.entity.Levels;
import ir.test.bookstore.modules.users.entity.Users;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_admins")
public class Admins {
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
    @Column(name = "created_at" , updatable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private long phonenumber;
    private long mobilenumber;
    private String role;
    private String province;
    private String city;
    private String image;

    @OneToOne
    private Admins createdby;

    @OneToMany(mappedBy = "createdBy")
    private List<Users> users;

    @OneToMany(mappedBy = "createdBy")
    private List<Levels> levels;

    @OneToMany(mappedBy = "createdBy")
    private List<Books> books;

    @OneToMany(mappedBy = "createdBy")
    private List<Borrow> borrows;

    @Transient
    @JsonIgnore
    private MultipartFile file;

    public Admins() {
    }

    public Admins(String firstname, String lastname, long nationalcode, String email, String password, String address, LocalDateTime lastlogin, LocalDateTime createdAt, LocalDateTime updatedAt,  long phonenumber, long mobilenumber, String role, String province, String city, String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalcode = nationalcode;
        this.email = email;
        this.password = password;
        this.address = address;
        this.lastlogin = lastlogin;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.phonenumber = phonenumber;
        this.mobilenumber = mobilenumber;
        this.role = role;
        this.province = province;
        this.city = city;
        this.image = image;
    }

    public Admins(String firstname, String lastname, long nationalcode, String email, String password, String address, long phonenumber, long mobilenumber, String role) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.nationalcode = nationalcode;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phonenumber = phonenumber;
        this.mobilenumber = mobilenumber;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProvince() {
        return province;
    }

    public Admins setProvince(String province) {
        this.province = province;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Admins setCity(String city) {
        this.city = city;
        return this;
    }

    public List<Users> getUsers() {
        return users;
    }

    public Admins setUsers(List<Users> users) {
        this.users = users;
        return this;
    }

    public List<Books> getBooks() {
        return books;
    }

    public Admins setBooks(List<Books> books) {
        this.books = books;
        return this;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public Admins setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
        return this;
    }

    public MultipartFile getFile() {
        return file;
    }

    public Admins setFile(MultipartFile file) {
        this.file = file;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Admins setImage(String image) {
        this.image = image;
        return this;
    }
}
