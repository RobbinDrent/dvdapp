package com.example.DvdManager.DvdManager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

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
    @Cascade(CascadeType.ALL)
    private Film film;

    public Disc(String distributor, String format, Film film) {
        this.distributor = distributor;
        this.format = format;
        this.film = film;

    }


}
