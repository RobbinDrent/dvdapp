package com.example.DvdManager.DvdManager.dto;

import com.example.DvdManager.DvdManager.model.Director;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public record DiscDTO (
        Long discId,
        Long filmId,
        String format,
        String distributor,
        String filmTitle
) {
}
