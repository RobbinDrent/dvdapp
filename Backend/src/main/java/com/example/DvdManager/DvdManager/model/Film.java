package com.example.DvdManager.DvdManager.model;

import com.example.DvdManager.DvdManager.dto.DirectorDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Robbin Drent <r.v.drent@st.hanze.nl>
 * <p>
 * Dit is wat het programma doet.
 */
@Entity
@Getter @Setter @NoArgsConstructor
public class Film {

    @Id
    @GeneratedValue
    private Long filmId;

    private String title;

    private int releaseYear;

    private String displayTitle;

    @ManyToOne(fetch = FetchType.LAZY)
    @Cascade({CascadeType.PERSIST})
    private Director director;

    public void setDisplayTitle () {
        String tempString = this.title;
        if (this.title.startsWith("The ")) {
            tempString = tempString.replace("The ", "");
            tempString = tempString + ", The";
        }
        if (this.title.startsWith("the ")) {
            tempString = tempString.replace("the ", "");
            tempString = tempString + ", The";
        }
        if (this.title.startsWith("A ")) {
            tempString = tempString.replace("A ", "");
            tempString = tempString + ", A";
        } else if (this.title.startsWith("a ")) {
            tempString = tempString.replace("a ", "");
            tempString = tempString + ", A";
        }
        this.displayTitle = tempString;
    }
}
