package com.ibecole.ibecole.commun.enumerate;

public enum Sexe {

    HOMME('H', "Homme"),
    FEMME('F', "Femme");


    private char code;
    private String libelle;

    private Sexe(char code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public char getCode() {
        return code;
    }

    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return name();
    }
}
