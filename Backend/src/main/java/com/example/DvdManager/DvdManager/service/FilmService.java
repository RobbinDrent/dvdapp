package com.example.DvdManager.DvdManager.service;

import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.exception.FilmNotFoundException;
import com.example.DvdManager.DvdManager.mapper.FilmDTOMapper;
import com.example.DvdManager.DvdManager.model.Director;
import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.repository.DiscRepository;
import com.example.DvdManager.DvdManager.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepository filmRepository;
    private final FilmDTOMapper filmDTOMapper;
    private final DirectorService directorService;
    private final DiscRepository discRepository;


    public Film addFilm(FilmDTO filmDTO) {
        Film film = filmDTOMapper.toFilm(filmDTO);

        film.setDisplayTitle();
        filmRepository.save(film);
        return film;
    }

    public List<FilmDTO> findAllFilms() {
        List<Film> films = filmRepository.findAllByOrderByDisplayTitle();
        for (Film film : films) {
            film.setDisplayTitle();
        }
        List<FilmDTO> filmsToReturn = films.stream()
                .map(filmDTOMapper)
                .toList();
        return filmsToReturn;
    }

    public Film findFilmById(Long filmId) {
        Film film =  filmRepository.findByFilmId(filmId).orElseThrow(() ->
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
        return filmRepository.findFilmsByDirectorOrderByReleaseYear(director)
                .stream()
                .map(filmDTOMapper)
                .toList();
    }

//    public void addDiscToFilm(Disc disc, Film film) {
//        film.getDiscs().add(disc);
//        filmRepository.save(film);
//    }

    public void deleteFilmByFilmId(Long filmId) {
        Optional<Film> filmToRemove = filmRepository.findById(filmId);
        if (filmToRemove.isPresent()) {
            List<Disc> discsToRemove = discRepository.findDiscsByFilm(filmToRemove.get());
            for (Disc disc : discsToRemove) {
                discRepository.delete(disc);
            }
            filmRepository.deleteById(filmId);
        }
    }

//    public void removeDiscFromFilm(Long discId, Film film) {
//        film.getDiscs().remove(discRepository.findById(discId));
//    }
}
