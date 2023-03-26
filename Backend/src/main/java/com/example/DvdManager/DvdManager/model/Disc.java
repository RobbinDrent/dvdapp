package com.example.DvdManager.DvdManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Disc {

    @Id
    @GeneratedValue
    private Long discId;
    private String distributor;
    private String format;
    @ManyToOne
    private Film film;

    public Disc(String distributor, String format, Film film) {
        this.distributor = distributor;
        this.format = format;
        this.film = film;

    }


}
