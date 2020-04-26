package ir.test.bookstore.modules.borrow.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import ir.test.bookstore.modules.admins.entity.Admins;
import ir.test.bookstore.modules.books.entity.Books;

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
    private long bookid;
    private long adminid;
    private long borrowdays;
    private long levelid;
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
    private Admins admins;

    public Borrow() {
    }

    public Borrow(long userid, long bookid, long adminid, long borrowdays, long levelid, boolean refund, LocalDateTime endDate, LocalDateTime startDate) {
        this.userid = userid;
        this.bookid = bookid;
        this.adminid = adminid;
        this.borrowdays = borrowdays;
        this.levelid = levelid;
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

    public long getBookid() {
        return bookid;
    }

    public void setBookid(long bookid) {
        this.bookid = bookid;
    }

    public long getAdminid() {
        return adminid;
    }

    public void setAdminid(long adminid) {
        this.adminid = adminid;
    }

    public long getBorrowdays() {
        return borrowdays;
    }

    public void setBorrowdays(long borrowdays) {
        this.borrowdays = borrowdays;
    }

    public long getLevelid() {
        return levelid;
    }

    public void setLevelid(long levelid) {
        this.levelid = levelid;
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
}



