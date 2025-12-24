package com.app.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@IdClass(AuthorityId.class)
public class Authority {

    @Id
    @Column(name = "username", length = 50)
    private String username;

    @Id
    @Column(name = "authority", length = 50)
    private String authority;

    // constructors
    public Authority() {}

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    // getters & setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}