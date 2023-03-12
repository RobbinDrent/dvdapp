package com.example.DvdManager.DvdManager.controller;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.service.DiscService;
import lombok.RequiredArgsConstructor;
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

@CrossOrigin(originPatterns = "http://localhost:4200")
@RestController
@RequestMapping("/disc")
@RequiredArgsConstructor
public class DiscController {

    private final DiscService discService;

    @GetMapping("/all")
    public ResponseEntity<List<DiscDTO>> getAllDiscs() {
        List<DiscDTO> discs = discService.findAllDiscs();
        return new ResponseEntity<>(discs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDisc(@RequestBody DiscDTO discDTO, BindingResult result) {
        Disc disc = new Disc();
        if (!result.hasErrors()) {
            discService.addDisc(discDTO);
        }
        discService.addFilmtoDisc(discDTO.filmId(), disc);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/film/{filmId}")
    public ResponseEntity<List<DiscDTO>> getDiscsOfMovie (@PathVariable("filmdId") Film film) {
        List<DiscDTO> discs = discService.getDisOfMovie(film);
        return new ResponseEntity<>(discs, HttpStatus.OK);
    }
}
