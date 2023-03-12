package com.example.DvdManager.DvdManager.dto;

import com.example.DvdManager.DvdManager.model.Director;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public record DiscDTO (
        Long discId,
        Long filmId,
        String filmTitle,
        String filmDirectorFirstName,
        String filmDirectorLastName,
        String format,
        String distributor
) {
}
