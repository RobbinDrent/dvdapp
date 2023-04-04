package com.example.DvdManager.DvdManager.mapper;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.repository.FilmRepository;
import com.example.DvdManager.DvdManager.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Service @RequiredArgsConstructor
public class DiscDTOMapper implements Function<Disc, DiscDTO> {


    private final FilmRepository filmRepository;
    @Override
    public DiscDTO apply(Disc disc) {
        return new DiscDTO(
                disc.getDiscId(),
                disc.getFilm().getFilmId(),
                disc.getFormat(),
                disc.getDistributor(),
                disc.getFilm().getTitle()
        );
    }

    public Disc toDisc(DiscDTO discDTO) {
        return new Disc(
                discDTO.discId(),
                discDTO.distributor(),
                discDTO.format(),
                filmRepository.findById(discDTO.filmId()).get()
        );
    }
}
