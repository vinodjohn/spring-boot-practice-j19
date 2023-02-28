package com.sda.study.springbootpractice.repositories;

import com.sda.study.springbootpractice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository to handle all Student related DB operations
 *
 * @author Vinod John
 * @Date 22.02.2023
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByName(String name);
}
