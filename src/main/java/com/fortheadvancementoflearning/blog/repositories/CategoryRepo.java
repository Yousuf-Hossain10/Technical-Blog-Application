package com.fortheadvancementoflearning.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fortheadvancementoflearning.blog.entities.Categories;

public interface CategoryRepo extends JpaRepository<Categories, Integer>{

}
