package com.example.DvdManager.DvdManager.mapper;

import com.example.DvdManager.DvdManager.dto.DirectorDTO;
import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.model.Director;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Service
public class FilmDTOMapper implements Function<Film, FilmDTO> {

    DirectorDTOMapper directorDTOMapper;
    @Override
    public FilmDTO apply(Film film) {
        return new FilmDTO(
                film.getFilmId(),
                film.getTitle(),
                film.getDirector().getDirectorId(),
                film.getDirector().getFirstName(),
                film.getDirector().getLastName(),
                film.getDisplayTitle()
        );
    }

    public Film toFilm(FilmDTO filmDTO) {
        Film film = new Film();
        film.setTitle(filmDTO.title());
        return film;
    }
}
