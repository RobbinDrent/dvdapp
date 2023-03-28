package com.example.DvdManager.DvdManager.controller;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.mapper.DiscDTOMapper;
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
    private final DiscDTOMapper discDTOMapper;

    @GetMapping("/all")
    public ResponseEntity<List<DiscDTO>> getAllDiscs() {
        List<DiscDTO> discs = discService.findAllDiscs();
        return new ResponseEntity<>(discs, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addDisc(@RequestBody DiscDTO discDTO, BindingResult result) {
        if (!result.hasErrors()) {
            discService.addDisc(discDTO);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/film/{filmId}")
    public ResponseEntity<List<DiscDTO>> getDiscsOfMovie(@PathVariable("filmId") Long filmId) {
        List<DiscDTO> discs = discService.getDiscsOfMovie(filmId);
        return new ResponseEntity<>(discs, HttpStatus.OK);
    }

    @GetMapping("/{discId}")
    public ResponseEntity<DiscDTO> getDiscById(@PathVariable("discId") Long discId) {
        DiscDTO disc = discDTOMapper.apply(discService.getDiscById(discId));
        return new ResponseEntity<>(disc, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{discId}")
    public ResponseEntity<String> deleteDisc(@PathVariable("discId") Long discId) {
        discService.deleteDisc(discId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
