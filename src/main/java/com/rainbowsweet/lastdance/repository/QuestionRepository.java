package com.rainbowsweet.lastdance.repository;

import com.rainbowsweet.lastdance.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    List<Question> findByTitle(String title);

    List<Question> findByQuestion(String question);

    List<Question> findByLikescount(int liksecount);

}
