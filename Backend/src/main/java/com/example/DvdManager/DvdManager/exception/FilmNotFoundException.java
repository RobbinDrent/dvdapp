package com.example.DvdManager.DvdManager.exception;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class FilmNotFoundException extends RuntimeException {

    public FilmNotFoundException(String message) { super(message);};
}
