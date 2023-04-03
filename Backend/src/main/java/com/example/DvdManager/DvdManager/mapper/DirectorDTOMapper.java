package com.example.DvdManager.DvdManager.mapper;

import com.example.DvdManager.DvdManager.dto.DirectorDTO;
import com.example.DvdManager.DvdManager.model.Director;
import com.example.DvdManager.DvdManager.service.DirectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Service
@RequiredArgsConstructor
public class DirectorDTOMapper implements Function<Director, DirectorDTO> {

    @Override
    public DirectorDTO apply(Director director) {
        return new DirectorDTO(
                director.getDirectorId(),
                director.getFirstName(),
                director.getLastName(),
                director.getCountry(),
                director.getFilms().size()
        );
    }

    public Director toDirector(DirectorDTO directorDTO) {
        Director director = new Director();
        director.setFirstName(directorDTO.firstname());
        director.setLastName(directorDTO.lastname());
        director.setCountry(directorDTO.country());
        return director;
    }
}
