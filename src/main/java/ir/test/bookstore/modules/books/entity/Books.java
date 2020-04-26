package ir.test.bookstore.modules.books.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.test.bookstore.modules.admins.entity.Admins;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tbl_books")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Books {
    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String subject;
    private String author;
    private String cover;
    private long publishYear;
    private long count; //tedadekol
    private long balance; //mojodi
    @Column(name = "created_at" , updatable = false )
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private long createdBy;

    @Transient
    @JsonIgnore
    private MultipartFile file;


    @OneToMany(mappedBy = "books")
    private List<Comments> comments;

    @ManyToOne
    private Admins admins;

    public Books(String name, String subject, String author, String cover, long publishYear, long count, long balance, long createdBy) {
        this.name = name;
        this.subject = subject;
        this.author = author;
        this.cover = cover;
        this.publishYear = publishYear;
        this.count = count;
        this.balance = balance;
        this.createdBy = createdBy;
    }

    public Books() {
    }

    public String getCover() {
        return cover;
    }

    public Books setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getName() {
        return name;
    }

    public Books setName(String name) {
        this.name = name;
        return this;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public Books setComments(List<Comments> comments) {
        this.comments = comments;
        return this;
    }

    public Admins getAdmins() {
        return admins;
    }

    public Books setAdmins(Admins admins) {
        this.admins = admins;
        return this;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(long publishYear) {
        this.publishYear = publishYear;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
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

    public long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(long createdBy) {
        this.createdBy = createdBy;
    }

    public MultipartFile getFile() {
        return file;
    }

    public Books setFile(MultipartFile file) {
        this.file = file;
        return this;
    }
}
