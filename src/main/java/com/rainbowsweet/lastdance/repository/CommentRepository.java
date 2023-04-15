package com.rainbowsweet.lastdance.repository;

import com.rainbowsweet.lastdance.entity.Comment;
import com.rainbowsweet.lastdance.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findByAuthor(Member author);

}
