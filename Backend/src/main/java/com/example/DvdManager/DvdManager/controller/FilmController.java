package com.example.DvdManager.DvdManager.controller;

import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.mapper.FilmDTOMapper;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.service.DirectorService;
import com.example.DvdManager.DvdManager.service.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/film")
public class FilmController {

    private final FilmService filmService;
    private final FilmDTOMapper filmDTOMapper;
    private final DirectorService directorService;

    public FilmController(FilmService filmService, DirectorService directorService) {
        this.filmService = filmService;
        this.directorService = directorService;
        filmDTOMapper = new FilmDTOMapper();
    }
    @GetMapping("/all")
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        List<FilmDTO> films = filmService.findAllFilms();

        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFilm(@RequestBody FilmDTO filmDTO, BindingResult result) {
        Film film = new Film();
//        System.out.println("filmtitel: " + filmDTO.title());
//        System.out.println(filmDTO.displayTitle());
        System.out.println("FilmDTO directorId: " + filmDTO.directorId());
        if (!result.hasErrors()) {
            film = filmService.addFilm(filmDTO);
        }
        System.out.println("film titel: " + film.getTitle());
        System.out.println("film id: " + film.getFilmId());
        System.out.println("DirectorId koeken: " + filmDTO.directorId());
        filmService.addDirectorToFilm(filmDTO.directorId(), film);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{filmId}")
    public ResponseEntity<FilmDTO> getFilmByFilm(@PathVariable("filmId") Long filmId) {
        FilmDTO filmToSHow = filmDTOMapper.apply(filmService.findFilmById(filmId));
        return new ResponseEntity<>(filmToSHow, HttpStatus.OK);
    }
}
