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
    private boolean isDvd;
    @ManyToOne
    @Cascade(CascadeType.ALL)
    private Film film;
}
