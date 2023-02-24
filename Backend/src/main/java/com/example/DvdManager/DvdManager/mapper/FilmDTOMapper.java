package com.example.DvdManager.DvdManager.mapper;

import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.model.Film;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Service
public class FilmDTOMapper implements Function<Film, FilmDTO> {

    @Override
    public FilmDTO apply(Film film) {
        return new FilmDTO(
                film.getFilmId(),
                film.getTitle()
        );
    }

    public Film toFilm(FilmDTO filmDTO) {
        Film film = new Film();
        film.setTitle(filmDTO.title());
        return film;
    }
}
