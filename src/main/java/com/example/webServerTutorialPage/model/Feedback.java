package com.example.webServerTutorialPage.model;

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
    private int progress;

    @Column(name = "filepath")
    private String filepath;

    @Column(name = "date")
    private String date;

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public String getContent() {
        return content;
    }

    public String getFilepath() {
        return filepath;
    }

    public int getProgress() {
        return progress;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setProgress(int progress) {
        this.progress = progress;
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
                '}';
    }
}
