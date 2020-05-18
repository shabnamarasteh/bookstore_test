package ir.test.bookstore.modules.books.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.test.bookstore.modules.admins.entity.Admins;
import ir.test.bookstore.modules.borrow.entity.Borrow;
import javafx.beans.DefaultProperty;
import org.hibernate.annotations.ColumnDefault;
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
    private long publishYear;
    private long count; //tedadekol
    @Column(nullable = true)
    private long balance; //mojodi
    @Column(name = "created_at" , updatable = false )
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String image;

    @Transient
    @JsonIgnore
    private MultipartFile file;

    @OneToMany(mappedBy = "books")
    private List<Comments> comments;

    @OneToMany(mappedBy = "bookid")
    private List<Borrow> borrows ;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private Admins createdBy;

    public Books(String name, String subject, String author, long publishYear, long count, long balance) {
        this.name = name;
        this.subject = subject;
        this.author = author;
        this.publishYear = publishYear;
        this.count = count;
        this.balance = balance;
    }

    public Books() {
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

    public MultipartFile getFile() {
        return file;
    }

    public Books setFile(MultipartFile file) {
        this.file = file;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Books setImage(String image) {
        this.image = image;
        return this;
    }

    public List<Borrow> getBorrows() {
        return borrows;
    }

    public Books setBorrows(List<Borrow> borrows) {
        this.borrows = borrows;
        return this;
    }

    public Admins getCreatedBy() {
        return createdBy;
    }

    public Books setCreatedBy(Admins createdBy) {
        this.createdBy = createdBy;
        return this;
    }
}
