package com.example.listviewtest;

public class ListItem {
    private String pais;
    private String nContinente;

    public ListItem( String pais, String nContinente) {

        this.pais = pais;
        this.nContinente = nContinente;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getnContinente() {
        return nContinente;
    }

    public void setnContinente(String nContinente) {
        this.nContinente = nContinente;
    }

}
