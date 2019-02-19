package be.ehb.notedroid.model;

import java.io.Serializable;
import java.util.Date;

public class Note implements Serializable {

    private String titel, inhoud;
    private Date aanmaakdatum;


    public Note() {
    }

    public Note(String titel, String inhoud, Date aanmaakdatum) {
        this.titel = titel;
        this.inhoud = inhoud;
        this.aanmaakdatum = aanmaakdatum;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getInhoud() {
        return inhoud;
    }

    public void setInhoud(String inhoud) {
        this.inhoud = inhoud;
    }

    public Date getAanmaakdatum() {
        return aanmaakdatum;
    }

    public void setAanmaakdatum(Date aanmaakdatum) {
        this.aanmaakdatum = aanmaakdatum;
    }
}
