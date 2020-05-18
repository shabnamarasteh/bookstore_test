package ir.test.bookstore.modules.levels.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.test.bookstore.modules.admins.entity.Admins;
import ir.test.bookstore.modules.users.entity.Users;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_levels")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Levels {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private float price;
    private long days;
    private String description;
    private String cover;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "level")
    private List<Users> users;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private Admins createdBy;

    @Transient
    @JsonIgnore
    private MultipartFile file;

    public Levels() {
    }

    public Levels(String name, float price, long days) {
        this.name = name;
        this.price = price;
        this.days = days;
    }

    public Levels(String name, float price, long days, String description, String cover, Admins createdBy, MultipartFile file) {
        this.name = name;
        this.price = price;
        this.days = days;
        this.description = description;
        this.cover = cover;
        this.createdBy = createdBy;
        this.file = file;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public long getDays() {
        return days;
    }

    public void setDays(long days) {
        this.days = days;
    }

    public Admins getCreatedBy() {
        return createdBy;
    }

    public Levels setCreatedBy(Admins createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDescription() {
        return description;
    }

    public Levels setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public Levels setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public List<Users> getUsers() {
        return users;
    }

    public Levels setUsers(List<Users> users) {
        this.users = users;
        return this;
    }

    public MultipartFile getFile() {
        return file;
    }

    public Levels setFile(MultipartFile file) {
        this.file = file;
        return this;
    }
}
