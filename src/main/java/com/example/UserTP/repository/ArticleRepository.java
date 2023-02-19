package com.example.UserTP.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.UserTP.entity.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {


}
