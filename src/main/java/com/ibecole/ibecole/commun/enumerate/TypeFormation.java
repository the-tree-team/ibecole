package com.ibecole.ibecole.commun.enumerate;

public enum TypeFormation {

    TYPEA(  "Typea"),
    TYPEB(  "typeb");


    private char code;
    private String libelle;

    private TypeFormation(  String libelle) {
        this.libelle = libelle;
    }


    public String getLibelle() {
        return libelle;
    }

    @Override
    public String toString() {
        return name();
    }
}
