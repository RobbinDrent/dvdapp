package com.example.DvdManager.DvdManager.service;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.mapper.DiscDTOMapper;
import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.repository.DiscRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Service
public class DiscService {
    
    private final DiscRepository discRepository;
    private final DiscDTOMapper discDTOMapper;
    private final FilmService filmService;

    @Autowired
    public DiscService(DiscRepository discRepository, DiscDTOMapper discDTOMapper, FilmService filmService) {
        this.discRepository = discRepository;
        this.discDTOMapper = discDTOMapper;
        this.filmService = filmService;
    }

   public List<DiscDTO> findAllDiscs() {
        return discRepository.findAll()
                .stream()
                .map(discDTOMapper)
                .toList();
   }

   public Disc addDisc(DiscDTO discDTO) {
        Disc disc = discDTOMapper.toDisc(discDTO);
       System.out.println(disc.getDiscId());
       System.out.println(disc.getDistributor());
       System.out.println(disc.getFormat());
       System.out.println(disc.getFilm().getTitle());
       discRepository.save(disc);
        return disc;
   }

   public List<DiscDTO> getDisOfMovie(Film film) {
       return discRepository.findDiscsByFilm(film)
               .stream()
               .map(discDTOMapper)
               .toList();
   }

    public void addFilmtoDisc(Long filmId, Disc disc) {
        Film film = filmService.findFilmById(filmId);
        disc.setFilm(film);
        filmService.addDiscToFilm(disc, film);
        discRepository.save(disc);
    }
}
