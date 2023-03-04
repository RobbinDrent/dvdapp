package com.example.DvdManager.DvdManager.mapper;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.dto.FilmDTO;
import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.model.Film;
import com.example.DvdManager.DvdManager.repository.FilmRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Service
public class DiscDTOMapper implements Function<Disc, DiscDTO> {

    @Override
    public DiscDTO apply(Disc disc) {
        return null;
    }
    public Disc toDisc(DiscDTO discDTO) {
        Disc disc = new Disc();
        disc.setDistributor(discDTO.distributor());
        return disc;
    }
}
