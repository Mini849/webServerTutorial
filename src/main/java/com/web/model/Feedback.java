package com.web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_FEEDBACK")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "priority")
    private String priority;

    @Column(name = "category")
    private String category;

    @Column(name = "content")
    private String content;

    @Column(name = "progress")
    private boolean progress;

    @Column(name = "filepath")
    private String filepath;

    @Column(name = "date")
    private String date;

    @Column(name = "position")
    private String position;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isProgress() {
        return progress;
    }

    public void setProgress(boolean progress) {
        this.progress = progress;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", priority='" + priority + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", progress=" + progress +
                ", filepath='" + filepath + '\'' +
                ", date='" + date + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}


