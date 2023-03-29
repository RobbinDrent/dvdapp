package com.example.DvdManager.DvdManager.repository;

import com.example.DvdManager.DvdManager.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<Director, Long> {

    List<Director> findAllByOrderByLastName();
    Optional<Director> findById(Long directorId);
}
