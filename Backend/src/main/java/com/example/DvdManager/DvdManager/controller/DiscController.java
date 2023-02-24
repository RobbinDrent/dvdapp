package com.example.DvdManager.DvdManager.controller;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.service.DiscService;
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
    public ResponseEntity<String> addDisc(@RequestBody DiscDTO discDTO) {
        discService.addDisc(discDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
