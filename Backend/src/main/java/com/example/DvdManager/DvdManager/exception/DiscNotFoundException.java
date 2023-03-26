package com.example.DvdManager.DvdManager.exception;

import com.example.DvdManager.DvdManager.model.Disc;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
public class DiscNotFoundException extends RuntimeException {

    public DiscNotFoundException(String message) {super(message);};
}
