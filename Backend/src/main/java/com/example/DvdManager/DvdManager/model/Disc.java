package com.example.DvdManager.DvdManager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */

@Entity
@Getter @Setter @NoArgsConstructor
public class Disc {

    @Id
    @GeneratedValue
    private Long discId;
    private String distributor;
    @ManyToOne
    private Film film;
}
