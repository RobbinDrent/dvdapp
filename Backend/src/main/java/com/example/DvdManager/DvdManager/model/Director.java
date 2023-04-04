package com.example.DvdManager.DvdManager.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import java.util.List;
import java.util.Set;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Entity
@Table(name = "directors")
@Getter @Setter @NoArgsConstructor
public class Director {

    @Id
    @GeneratedValue
    private Long directorId;

    private String firstName;
    private String lastName;
    private String country;

    @OneToMany(mappedBy = "director")
    @Cascade(org.hibernate.annotations.CascadeType.PERSIST)
    private List<Film> films;


}
