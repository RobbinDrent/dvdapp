package com.example.DvdManager.DvdManager.service;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.exception.DiscNotFoundException;
import com.example.DvdManager.DvdManager.exception.FilmNotFoundException;
import com.example.DvdManager.DvdManager.mapper.DiscDTOMapper;
import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.repository.DiscRepository;
import com.example.DvdManager.DvdManager.repository.FilmRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Service
@RequiredArgsConstructor
public class DiscService {

    private final DiscRepository discRepository;
    private final DiscDTOMapper discDTOMapper;
    private final FilmService filmService;

    private final FilmRepository filmRepository;

   public List<DiscDTO> findAllDiscs() {
        return discRepository.findAll()
                .stream()
                .map(discDTOMapper)
                .toList();
   }

   public void addDisc(DiscDTO discDTO) {
        Disc disc = discDTOMapper.toDisc(discDTO);
        discRepository.save(disc);
   }

   public List<DiscDTO> getDiscsOfMovie(Long filmId) {
        Film film = filmRepository.findById(filmId).orElseThrow(() ->
                new FilmNotFoundException("Film met id " + filmId + " niet gevonden!"));
        return discRepository.findDiscsByFilm(film)
               .stream()
               .map(discDTOMapper)
               .toList();
   }

    public void addFilmtoDisc(Long filmId, Disc disc) {
        Film film = filmService.findFilmById(filmId);
        disc.setFilm(film);
        discRepository.save(disc);
        filmService.addDiscToFilm(disc, film);
    }

    public Disc getDiscById(Long discId) {
        Disc disc = discRepository.findById(discId).orElseThrow(() ->
                new DiscNotFoundException("Disc with id " + discId + " niet gevonden."));
        return disc;

    }

    public void deleteDisc(Long discId) {
        discRepository.deleteById(discId);
    }
}
