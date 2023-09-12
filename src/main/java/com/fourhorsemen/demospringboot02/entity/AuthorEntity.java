package com.fourhorsemen.demospringboot02.entity;

import javax.persistence.*;

@Entity(name = "author")
public class AuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "authorname")
    private String authorName;
    @Column(name = "fullname")
    private String fullName;
    @Column(name = "gender")
    private String gender;

    public AuthorEntity() {
    }

    public AuthorEntity(int id, String authorName, String fullName, String gender) {
        this.id = id;
        this.authorName = authorName;
        this.fullName = fullName;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
