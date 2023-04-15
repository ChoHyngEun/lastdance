package com.rainbowsweet.lastdance.entity;


import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
@DynamicUpdate
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name ="author_memberid", referencedColumnName = "memberid")
    private Member author;

    private LocalDateTime createdAt;

    @ManyToOne
    private Community community;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Member getAuthor() {
        return author;
    }

    public void setAuthor(Member author) {
        this.author = author;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Community getCommunity() {
        return community;
    }

    public void setCommunity(Community community) {
        this.community = community;
    }

    public Comment(Long id, String content, Member author, LocalDateTime createdAt, Community community){
        this.id = id;
        this.content = content;
        this.author = author;
        this.createdAt = createdAt;
        this.community = community;
    }

    public Comment() {

    }

    public String getAuthorMemberid() {
        if(author != null){
            return author.getMemberId();
        }
        return null;
    }
}
