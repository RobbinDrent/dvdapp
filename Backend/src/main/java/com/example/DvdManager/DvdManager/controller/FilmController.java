package com.example.DvdManager.DvdManager.controller;

import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/all")
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        List<FilmDTO> films = filmService.findAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addFilm(@RequestBody FilmDTO filmDTO) {
        filmService.addFilm(filmDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
