package com.rainbowsweet.lastdance.model;


import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;
import com.rainbowsweet.lastdance.model.Comment;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@DynamicUpdate
@NoArgsConstructor
public class Community {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column
    private String content;

    @ManyToOne
    @JoinColumn(name = "author_memberid", referencedColumnName = "memberid")
    private Member author;


    private LocalDateTime createAt;

    private LocalDateTime updateAt;


    public enum Category {

    }

    @Column(name = "category")
    @Enumerated(EnumType.STRING)
    private Category category;

    @OneToMany(mappedBy = "community", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();

    public Community(String title, String content, Member author){
        this.title = title;
        this.content = content;
        this.author = author;
        this.createAt = LocalDateTime.now();
    }

    //getters. setters. constructor


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

    public LocalDateTime getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(LocalDateTime updateAt) {
        this.updateAt = updateAt;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
