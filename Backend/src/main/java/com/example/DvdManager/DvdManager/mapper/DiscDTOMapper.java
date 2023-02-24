package com.example.DvdManager.DvdManager.mapper;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.model.Disc;
import com.example.DvdManager.DvdManager.service.DiscService;
import com.example.DvdManager.DvdManager.service.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Service
@RequiredArgsConstructor
public class DiscDTOMapper implements Function<Disc, DiscDTO> {

    @Override
    public DiscDTO apply(Disc disc) {
        return new DiscDTO(
                disc.getDiscId(),
                disc.getFilm().getTitle(),
                disc.getDistributor()
        );
    }

    public Disc toDisc(DiscDTO discDTO) {
        Disc disc = new Disc();
        disc.setDiscId(discDTO.discId());
        disc.setDistributor(discDTO.distributor());
        return disc;
    }
}
