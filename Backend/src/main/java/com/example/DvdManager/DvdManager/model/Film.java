package com.example.DvdManager.DvdManager.model;

import com.example.DvdManager.DvdManager.dto.DirectorDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue
    private Long filmId;

    private String title;

    @ManyToMany
    private Set<Director> directors;

    @ManyToMany
    private List<Disc> discs;

}
