package com.rainbowsweet.lastdance.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;
    private String title;

    @Column(columnDefinition = "varchar(300)")
    private String answer;

    private Date date;

    private String author;

    private boolean pick;

    private boolean likes;

    private int likesCount;


    public Question(){
    }
    public Question(String question, String answer, String author, Date date, String title, boolean pick, boolean likes, int likesCount) {
        this.question = question;
        this.title = title;
        this.answer = answer;
        this.author = author;
        this.date = date;
        this.pick = pick;
        this.likes = likes;
        this.likesCount = likesCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isPick() {
        return pick;
    }

    public void setPick(boolean pick) {
        this.pick = pick;
    }

    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    public int getLikesCount() {
        return likesCount;
    }

    public void setLikesCount(int likesCount) {
        this.likesCount = likesCount;
    }
}
