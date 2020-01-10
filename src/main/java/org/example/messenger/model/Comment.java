package org.example.messenger.model;

import java.util.Date;

public class Comment {
    private long id;
    private String comment;
    private String author;
    private Date createdAt;

    public Comment(long id, String comment, String author) {
        this.id = id;
        this.comment = comment;
        this.author = author;
        this.createdAt = new Date();
    }

    public Comment() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
