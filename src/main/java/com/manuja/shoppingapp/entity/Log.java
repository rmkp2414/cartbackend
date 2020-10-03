package com.manuja.shoppingapp.entity;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
@Entity @Table(name = "Log")
public class Log {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "userid")
    private Integer userId;
    @Column(name = "ldate")
    private Date loginDate;
    @Column(name = "login_time")
    private Time loginTime;
    @Column(name = "logout_time")
    private Time logoutTime;

    public Log() {
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", userId=" + userId +
                ", loginDate=" + loginDate +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public Time getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Time loginTime) {
        this.loginTime = loginTime;
    }

    public Time getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Time logoutTime) {
        this.logoutTime = logoutTime;
    }
}
