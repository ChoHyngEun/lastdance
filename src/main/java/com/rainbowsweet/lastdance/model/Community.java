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

    private boolean likes;

    private boolean view;

    private boolean answer;

    private boolean answerpick;

    private int likescount;

    private int viewcount;

    private int answercount;

    private int anwerpickount;

    private String question;

    private int questioncount;

    public enum ClassCategory {
        data("데이터 사이언티스트"),
        python("python 풀스택 개발자"),
        js_front("JS 프론트엔드 개발자"),
        js_back("JS 백엔드 개발자"),
        begginer("코딩 초보 필수! 프로그래밍 오버뷰"),
        html_css("HTML/CSS로 웹사이트 만들기"),
        python_begginer("python 기초"),
        js_begginer("js 기초"),
        sql_data("비개발자를 위한 SQL 데이터분석"),
        Figma_UI("Figma로 시작하는 UI디자인"),
        react_front("React 프론트엔드 개발"),
        Nodejs("Node js 백엔드 개발"),
        bigdata("빅데이터 분석, 기초에서 실전까지");

        private String korName; //각 enum 상수에 대응되는 한글 표현을 함께 지정해줌

        ClassCategory(String korName) {
            this.korName = korName;
        }

        public String getKorName() {
            return korName;
        }

    }

    @Column(name = "classcategory")
    @Enumerated(EnumType.STRING)
    private ClassCategory classcategory;

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

    public ClassCategory getClassCategory() {
        return classcategory;
    }

    public void setClassCategory(ClassCategory classcategory) {
        this.classcategory = classcategory;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }


    public boolean isLikes() {
        return likes;
    }

    public void setLikes(boolean likes) {
        this.likes = likes;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public boolean isAnswerpick() {
        return answerpick;
    }

    public void setAnswerpick(boolean answerpick) {
        this.answerpick = answerpick;
    }

    public int getLikescount() {
        return likescount;
    }

    public void setLikescount(int likescount) {
        this.likescount = likescount;
    }

    public int getViewcount() {
        return viewcount;
    }

    public void setViewcount(int viewcount) {
        this.viewcount = viewcount;
    }

    public int getAnswercount() {
        return answercount;
    }

    public void setAnswercount(int answercount) {
        this.answercount = answercount;
    }

    public int getAnwerpickount() {
        return anwerpickount;
    }

    public void setAnwerpickount(int anwerpickount) {
        this.anwerpickount = anwerpickount;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestioncount() {
        return questioncount;
    }

    public void setQuestioncount(int questioncount) {
        this.questioncount = questioncount;
    }

    public ClassCategory getClasscategory() {
        return classcategory;
    }

    public void setClasscategory(ClassCategory classcategory) {
        this.classcategory = classcategory;
    }



}
