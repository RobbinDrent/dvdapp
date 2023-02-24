package com.example.DvdManager.DvdManager.service;

import com.example.DvdManager.DvdManager.dto.DiscDTO;
import com.example.DvdManager.DvdManager.mapper.DiscDTOMapper;
import com.example.DvdManager.DvdManager.model.Disc;
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

    @Autowired
    public DiscService(DiscRepository discRepository, DiscDTOMapper discDTOMapper) {
        this.discRepository = discRepository;
        this.discDTOMapper = discDTOMapper;
    }

   public List<DiscDTO> findAllDiscs() {
        return discRepository.findAll()
                .stream()
                .map(discDTOMapper)
                .toList();
   }

   public Disc addDisc(DiscDTO discDTO) {
        Disc disc = discDTOMapper.toDisc(discDTO);
        return discRepository.save(disc);
   }
    
//    public List<D> findAllDirectors(Disc disc) {
//        return disc.getFilm().getDirectors()
//                .stream()
//                .map(direcorDTOMapper)
//                .toList();
//    }
}
