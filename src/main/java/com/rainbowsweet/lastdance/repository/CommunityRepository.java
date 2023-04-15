package com.rainbowsweet.lastdance.repository;

import com.rainbowsweet.lastdance.model.Community;
import com.rainbowsweet.lastdance.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommunityRepository extends JpaRepository<Community, Long> {
/*
* JpaRepository<Community, Long>은 jparepository인터페이스를 상속(extends)받아 Community 엔티티를 조작하는데 사용되는 인터페이스
* Community는 엔티티 클래스의 이름이고, Long은 Community의 기본 키 타입.
* 이 인터페이스를 사용하는 이유는 Community엔티티를 조작하는데 필요한 다양한 메서드들을 상속 받을 수 있다.
* 이러한 메서드들은 자동으로 작성되며, 커스텀 메서드를 추가하여 엔티티를 조작할 수도 있음. ex) @Autowired<- 같은것들로 커스텀 메서드를 추가
* 할 수 있음.
* */
    List<Community> findByAuthor(Member author);

    /*list<community> findebyauthor(member author)는 community엔티티에서 author 필드가 member 객체와 일치하는 모든 엔티티를 조회하는 메서드
    * community엔티티에서 author 필드가 member 객체와 일치하는 모든 엔티티를 리스트로 반환함.
    * 이메서드를 사용하면 community에닡티에서 author 필드를 기준으로 조회가능.
    * 이를 이용하면 community엔티티에서 특정 작성자의 게시물을 조회할 수 있음.*/

    List<Community> findAllByClasscategory(Community.ClassCategory classCategory);


    /*findAll<-을 쓴이유는 카테고리에 해당하는 모든 데이터를 찾을때 사용함.
    * */


}
