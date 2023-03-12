package com.example.DvdManager.DvdManager.service;

import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.exception.FilmNotFoundException;
import com.example.DvdManager.DvdManager.mapper.FilmDTOMapper;
import com.example.DvdManager.DvdManager.model.Director;
import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Service
public class FilmService {

    private final FilmRepository filmRepository;
    private final FilmDTOMapper filmDTOMapper;
    private final DirectorService directorService;

    @Autowired
    public FilmService(FilmRepository filmRepository, FilmDTOMapper filmDTOMapper, DirectorService directorService) {
        this.filmRepository = filmRepository;
        this.filmDTOMapper = filmDTOMapper;
        this.directorService = directorService;
    }

    public Film addFilm(FilmDTO filmDTO) {
        Film film = filmDTOMapper.toFilm(filmDTO);

//        Director director = directorService.findDirectorByDirectorId(film.getDirectors());
        film.setDisplayTitle();
//        film.addDirector(director);
//        director.getFilms().add(film);
        filmRepository.save(film);
        return film;
//        for (Director director : film.getDirectors()) {
//            System.out.println(director);
//
//        }
    }

    public List<FilmDTO> findAllFilms() {
        List<Film> films = filmRepository.findAll();
        for (Film film : films) {
            film.setDisplayTitle();
        }
        List<FilmDTO> filmsToReturn = films.stream()
                .map(filmDTOMapper)
                .toList();
        return filmsToReturn;
    }

    public Film findFilmById(Long filmId) {
        System.out.println("filmid: " + filmId);
        Film film =  filmRepository.findById(filmId).orElseThrow(() ->
        new FilmNotFoundException("Film met id " + filmId + " niet gevonden."));
        film.setDisplayTitle();
        return film;
    }

    public void addDirectorToFilm(Long directorId, Film film) {
        Director director = directorService.findDirectorByDirectorId(directorId);
        if (director == null) {
            System.out.println("director is null");
        }
        System.out.println("adddirectortofilm: " + director.getLastName());
        film.setDirector(director);
        directorService.addFilmToDirector(director, film);
        filmRepository.save(film);
    }

    public List<FilmDTO> findFilmsByDirector(Director director) {
        return filmRepository.findFilmsByDirector(director)
                .stream()
                .map(filmDTOMapper)
                .toList();
    }

    public void addDiscToFilm(Disc disc, Film film) {
        film.getDiscs().add(disc);
        filmRepository.save(film);
    }
}
