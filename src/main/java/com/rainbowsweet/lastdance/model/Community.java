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

    private String title; //제목
    @Column(columnDefinition = "text")
    private String content; //내용

    @ManyToOne
    @JoinColumn(name = "author_memberid", referencedColumnName = "memberid")
    private Member author; //작성자 명을 member클래스에서 가져오는것


    private LocalDateTime createAt;

    private LocalDateTime updateAt;


    private boolean likes; //좋아요버튼을 눌렀을때 true or false로 나눔

    private int likescount;

    /* *
     * likescount는 likes가 true 된것의 갯수 집합
     * */

    private int viewcount; //조회수 viewcount +1

    @Column(columnDefinition = "text")
    private String answer; //user들이 질문에 다는 답변

    private int answercount;

    private int pick; // 답변 채택 질문한 유저가 픽하는 (0,1) 0일경우 선택X 1일경우 선택O

    private boolean pickanswer;

    private boolean pickanswercount;

    private boolean question;

    private int questioncount;



    public enum ClassCategory {
        data("데이터 사이언티스트"),
        python("Python 풀스택 개발자"),
        js_frontend("자바스크립트 프론트엔드 개발자"),
        js_backend("자바스크립트 백엔드 개발자"),
        first_coding("코딩 초보 필수! 프로그래밍 오버뷰"),
        html_css("HTML / CSS로 웹사이트 만들기"),
        python_beginner("파이썬 기초"),
        js_beginner("자바스크립트 기초"),
        sqldata("비개발자를 위한 SQL 데이터분석"),
        Figma_UI("Figma로 시작하는 UI 디자인"),
        html_css2("HTML/CSS로 웹사이트 만들기");


        private String korName;

        ClassCategory(String korName) {
            this.korName = korName;
        }

        public String getKorName() {
            return korName;
        }


    }

    @Column(name = "classCategory")
    @Enumerated(EnumType.STRING)
    private ClassCategory classcategory;

    @OneToMany(mappedBy = "community", cascade = CascadeType.REMOVE)
    private List<Comment> comments = new ArrayList<>();
    /*
    * comment클래스에서 community 필드를 사용하여 community 클래스와 매핑
    * cascade는 엔티티와 영향을 직간접적으로 주고받는 엔티티들을 어떻게 처리할지 정합니다.
    * cascadetype.remove는 엔티티가 삭제될때 연관된 엔티티들도 같이 삭제가 됩니다.
    * community 객체가 삭제되면 커뮤니티에 작성된 모든댓글(comment 객체) 도 같이 삭제 됩니다.
    * */

    public Community(String title, String content, Member author, LocalDateTime createAt){
        this.title = title;
        this.content = content;
        this.author = author;
        this.createAt = LocalDateTime.now();
    }


    //getters. setters. constructor



}
