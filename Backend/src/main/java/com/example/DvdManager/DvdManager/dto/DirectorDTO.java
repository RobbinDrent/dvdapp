package com.example.DvdManager.DvdManager.dto;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public record DirectorDTO(
        Long directorId,
        String firstname,
        String lastname,
        String country
) {
}
