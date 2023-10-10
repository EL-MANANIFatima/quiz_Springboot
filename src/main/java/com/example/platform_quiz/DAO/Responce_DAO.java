package com.example.platform_quiz.DAO;

import com.example.platform_quiz.models.Reponce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface Responce_DAO extends JpaRepository<Reponce,Integer> {
   public List<Reponce> findReponcesByUser_IdAndQuestion_Category_Id(Integer id_user, Integer id_category);
   public List<Reponce> findReponcesByUser_Id(Integer id_user);
}
