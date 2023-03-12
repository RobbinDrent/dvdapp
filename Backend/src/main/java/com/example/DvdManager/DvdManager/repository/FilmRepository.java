package com.example.DvdManager.DvdManager.repository;

import com.example.DvdManager.DvdManager.model.Director;
import com.example.DvdManager.DvdManager.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FilmRepository extends JpaRepository<Film, Long> {

    List<Film> findFilmsByDirector(Director director);
    Optional<Film> findById(Long filmId);
}
