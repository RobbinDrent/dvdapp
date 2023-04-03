package com.example.DvdManager.DvdManager.controller;

import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.mapper.FilmDTOMapper;
import com.example.DvdManager.DvdManager.model.Director;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.service.DirectorService;
import com.example.DvdManager.DvdManager.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
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
@RequiredArgsConstructor
public class FilmController {

    private final FilmService filmService;
    private final FilmDTOMapper filmDTOMapper;
    private final DirectorService directorService;

    @GetMapping("/all")
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        List<FilmDTO> films = filmService.findAllFilms();

        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFilm(@RequestBody FilmDTO filmDTO, BindingResult result) {
        Film film = new Film();
        if (!result.hasErrors()) {
            film = filmService.addFilm(filmDTO);
        }
        filmService.addDirectorToFilm(filmDTO.directorId(), film);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{filmId}")
    public ResponseEntity<FilmDTO> getFilmByFilmId(@PathVariable("filmId") Long filmId) {
        FilmDTO filmToSHow = filmDTOMapper.apply(filmService.findFilmById(filmId));
        return new ResponseEntity<>(filmToSHow, HttpStatus.OK);
    }

    @GetMapping("/director/{directorId}")
    public ResponseEntity<List<FilmDTO>> getFilmsByDirectorId(@PathVariable("directorId") Director director ) {
        List<FilmDTO> films = filmService.findFilmsByDirector(director);
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{filmId}")
    public ResponseEntity<String> deleteFilmbyFilmId(@PathVariable("filmId") Long filmId ) {
        filmService.deleteFilmByFilmId(filmId);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
