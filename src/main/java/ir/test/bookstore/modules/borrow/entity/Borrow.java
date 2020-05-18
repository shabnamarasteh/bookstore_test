package ir.test.bookstore.modules.borrow.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.test.bookstore.modules.admins.entity.Admins;
import ir.test.bookstore.modules.books.entity.Books;
import ir.test.bookstore.modules.levels.entity.Levels;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_borrow")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class , property = "id")
public class Borrow {
    @Id
    @GeneratedValue
    private long id;
    private long userid;
    private long borrowdays;
    private boolean refund;
    private LocalDateTime endDate;
    private LocalDateTime startDate;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name="created_at")
    private LocalDateTime createdAt;

//    @ManyToMany
//    private Books books;

    @ManyToOne
    @JoinColumn(name = "bookid")
    private Books bookid;

    @ManyToOne
    @JoinColumn(name = "createdBy")
    private Admins createdBy;

    @OneToOne
    @JoinColumn(name = "levelid")
    private Levels levelid;

    public Borrow() {
    }

    public Borrow(long userid,long borrowdays, boolean refund, LocalDateTime endDate, LocalDateTime startDate) {
        this.userid = userid;
        this.borrowdays = borrowdays;
        this.refund = refund;
        this.endDate = endDate;
        this.startDate = startDate;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public long getBorrowdays() {
        return borrowdays;
    }

    public void setBorrowdays(long borrowdays) {
        this.borrowdays = borrowdays;
    }

    public boolean isRefund() {
        return refund;
    }

    public void setRefund(boolean refund) {
        this.refund = refund;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Admins getCreatedBy() {
        return createdBy;
    }

    public Borrow setCreatedBy(Admins createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Levels getLevelid() {
        return levelid;
    }

    public Borrow setLevelid(Levels levelid) {
        this.levelid = levelid;
        return this;
    }

    public Books getBookid() {
        return bookid;
    }

    public Borrow setBookid(Books bookid) {
        this.bookid = bookid;
        return this;
    }
}
