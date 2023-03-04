package com.example.DvdManager.DvdManager.dto;

import java.util.List;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public record FilmDTO (
    Long filmId,
    String title,
    Long directorId,
    String directorFirstName,
    String directorLastName,
    String displayTitle

    ){
}
