package com.example.DvdManager.DvdManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Entity
@Getter @Setter @NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue
    private Long directorId;

    private String firstName;
    private String lastName;
    private String country;

    @ManyToMany
    private Set<Film> films;

}
