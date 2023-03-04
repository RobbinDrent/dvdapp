package com.example.DvdManager.DvdManager.controller;

import com.example.DvdManager.DvdManager.dto.DirectorDTO;
import com.example.DvdManager.DvdManager.mapper.DirectorDTOMapper;
import com.example.DvdManager.DvdManager.service.DirectorService;
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
@RequestMapping("/director")
@RequiredArgsConstructor
public class DirectorController {

    private final DirectorService directorService;
    private final DirectorDTOMapper directorDTOMapper;

    @GetMapping("/all")
    public ResponseEntity<List<DirectorDTO>> getAllDirectors() {
        List<DirectorDTO> allDirectors = directorService.findAllDirectors();
        return new ResponseEntity<>(allDirectors, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<DirectorDTO> addDirector(@RequestBody DirectorDTO directorDTO) {
        directorService.addDirector(directorDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{directorId}")
    public ResponseEntity<DirectorDTO> getDirectorByDirectorId(@PathVariable("directorId") Long directorId) {
        DirectorDTO directorToShow = directorDTOMapper.apply(directorService.findDirectorByDirectorId(directorId));
        return new ResponseEntity<>(directorToShow, HttpStatus.OK);
    }
}
