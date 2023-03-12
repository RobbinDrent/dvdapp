package com.example.DvdManager.DvdManager.repository;

import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DiscRepository extends JpaRepository<Disc, Long> {

    List<Disc> findDiscsByFilm(Film film);
}
