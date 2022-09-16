package com.example.JPATesting;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

//public interface LessonRepo extends CrudRepository <Lesson, Long>{
public interface LessonRepo extends JpaRepository<Lesson, Long> {
}
