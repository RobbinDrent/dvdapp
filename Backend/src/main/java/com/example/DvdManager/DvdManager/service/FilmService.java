package com.example.DvdManager.DvdManager.service;

import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.mapper.FilmDTOMapper;
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

    @Autowired
    public FilmService(FilmRepository filmRepository, FilmDTOMapper filmDTOMapper) {
        this.filmRepository = filmRepository;
        this.filmDTOMapper = filmDTOMapper;
    }

    public Film addFilm(FilmDTO filmDTO) {
        Film film = filmDTOMapper.toFilm(filmDTO);
        return filmRepository.save(film);
    }

    public List<FilmDTO>  findAllFilms() {
        return filmRepository.findAll()
                .stream()
                .map(filmDTOMapper)
                .toList();
    }
}
