package de.ri.reader.model;

public class SupermarketData {

    // Static
    static public String LOREM_IPSUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    public SupermarketData() {
    }

    public SupermarketData(String id, String filiaal_num, String datum, String tijdstip, String klant_num, String nasa_num, String omsch, String inhoud_aantal, String eenheid, String ce_aantal) {
        this.id = id;
        this.filiaal_num = filiaal_num;
        this.datum = datum;
        this.tijdstip = tijdstip;
        this.klant_num = klant_num;
        this.nasa_num = nasa_num;
        this.omsch = omsch;
        this.inhoud_aantal = inhoud_aantal;
        this.eenheid = eenheid;
        this.ce_aantal = ce_aantal;
    }

    // Member variables.
    private String id;
    private String filiaal_num;
    private String datum;
    private String tijdstip;
    private String klant_num;
    private String nasa_num;
    private String omsch;
    private String inhoud_aantal;
    private String eenheid;
    private String ce_aantal;



    public String getFiliaal_num() {
        return filiaal_num;
    }

    public void setFiliaal_num(String filiaal_num) {
        this.filiaal_num = filiaal_num;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public String getTijdstip() {
        return tijdstip;
    }

    public void setTijdstip(String tijdstip) {
        this.tijdstip = tijdstip;
    }

    public String getKlant_num() {
        return klant_num;
    }

    public void setKlant_num(String klant_num) {
        this.klant_num = klant_num;
    }

    public String getNasa_num() {
        return nasa_num;
    }

    public void setNasa_num(String nasa_num) {
        this.nasa_num = nasa_num;
    }

    public String getOmsch() {
        return omsch;
    }

    public void setOmsch(String omsch) {
        this.omsch = omsch;
    }

    public String getInhoud_aantal() {
        return inhoud_aantal;
    }

    public void setInhoud_aantal(String inhoud_aantal) {
        this.inhoud_aantal = inhoud_aantal;
    }

    public String getEenheid() {
        return eenheid;
    }

    public void setEenheid(String eenheid) {
        this.eenheid = eenheid;
    }

    public String getCe_aantal() {
        return ce_aantal;
    }

    public void setCe_aantal(String ce_aantal) {
        this.ce_aantal = ce_aantal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
