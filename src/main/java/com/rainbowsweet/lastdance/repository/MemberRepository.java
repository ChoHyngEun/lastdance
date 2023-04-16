package com.rainbowsweet.lastdance.repository;

import com.rainbowsweet.lastdance.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//Jpa repo를 상속받아 CRUD 기능이 자동으로 제공됨.
@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    Member findByMemberId(String memberId);
    //member엔티티에서 memberId 필드를 이요하여 해당 memberid를 갖는 사용자를 찾아 반환함.

    Member findByEmail(String email);
    //member 엔티티에서 email필드를 이용해서 해당 email을 갖는 사용자를 찾아 반환함.

    List<Member> findByName(String Name);
}
