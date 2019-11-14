package com.example.shoppingapp.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "user_profile")
public class UserProfile {
    @Id
    private long userId = 0;
    private String token;
    private String logo_url;
    private String username;
    private String mobi;
    @Generated(hash = 1899773543)
    public UserProfile(long userId, String token, String logo_url, String username,
            String mobi) {
        this.userId = userId;
        this.token = token;
        this.logo_url = logo_url;
        this.username = username;
        this.mobi = mobi;
    }
    @Generated(hash = 968487393)
    public UserProfile() {
    }
    public long getUserId() {
        return this.userId;
    }
    public void setUserId(long userId) {
        this.userId = userId;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public String getLogo_url() {
        return this.logo_url;
    }
    public void setLogo_url(String logo_url) {
        this.logo_url = logo_url;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getMobi() {
        return this.mobi;
    }
    public void setMobi(String mobi) {
        this.mobi = mobi;
    }
}
