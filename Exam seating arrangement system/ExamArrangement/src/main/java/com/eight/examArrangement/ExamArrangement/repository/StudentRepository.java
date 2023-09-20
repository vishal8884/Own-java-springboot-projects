package com.eight.examArrangement.ExamArrangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eight.examArrangement.ExamArrangement.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Long>{

}
