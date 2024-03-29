

package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.TodoEntity;

/**
 * 科目情報 Repository
 */
@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {
}