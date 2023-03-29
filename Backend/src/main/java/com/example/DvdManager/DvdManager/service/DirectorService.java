package com.example.DvdManager.DvdManager.service;

import com.example.DvdManager.DvdManager.dto.DirectorDTO;
import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.exception.DirectorNotFoundException;
import com.example.DvdManager.DvdManager.exception.FilmNotFoundException;
import com.example.DvdManager.DvdManager.mapper.DirectorDTOMapper;
import com.example.DvdManager.DvdManager.model.Director;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.repository.DirectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Service @RequiredArgsConstructor
public class DirectorService {

    private final DirectorRepository directorRepository;
    private final DirectorDTOMapper directorDTOMapper;

    public List<DirectorDTO> findAllDirectors() {
        return directorRepository.findAllByOrderByLastName()
                .stream()
                .map(directorDTOMapper)
                .toList();
    }

    public Director addDirector(DirectorDTO directorDTO){
        Director director = directorDTOMapper.toDirector(directorDTO);
        return directorRepository.save(director);
    }

    public Director findDirectorByDirectorId(Long directorId) {
        Director director =  directorRepository.findById(directorId).orElseThrow(() ->
        new DirectorNotFoundException("Regisseur met id " + directorId + " niet gevonden."));
//        director.setDisplayName();
        return director;
    }

    public void addFilmToDirector(Director director, Film film) {
        director.getFilms().add(film);
        directorRepository.save(director);
    }
}
