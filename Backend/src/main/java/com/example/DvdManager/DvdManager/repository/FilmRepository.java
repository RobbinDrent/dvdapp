package com.example.DvdManager.DvdManager.repository;

import com.example.DvdManager.DvdManager.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
