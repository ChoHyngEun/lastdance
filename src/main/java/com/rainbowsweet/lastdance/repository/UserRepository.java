package com.rainbowsweet.lastdance.repository;

import com.rainbowsweet.lastdance.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Member, Long> {

    Member findByMemberId(String memberId);
    //member엔티티에서 memberId 필드를 이요하여 해당 memberid를 갖는 사용자를 찾아 반환함.

    Member findByEmail(String email);
    //member 엔티티에서 email필드를 이용해서 해당 email을 갖는 사용자를 찾아 반환함.


}
