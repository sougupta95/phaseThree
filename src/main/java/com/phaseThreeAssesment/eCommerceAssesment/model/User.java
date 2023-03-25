package com.phaseThreeAssesment.eCommerceAssesment.model;

import com.phaseThreeAssesment.eCommerceAssesment.Util.CryptoUtil;
import jakarta.persistence.*;

import java.sql.Date;
import java.util.Set;

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(unique = true)
    private String userName;

    private String password;
    private String email;
    private String phoneNumber;

    private Date createdAt;
    private Date updatedAt;

    public long getUserId() {
        return userId;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return CryptoUtil.getDecrypted(password);
    }

    public void setPassword(String password) {
        this.password = CryptoUtil.getEncrypted(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
