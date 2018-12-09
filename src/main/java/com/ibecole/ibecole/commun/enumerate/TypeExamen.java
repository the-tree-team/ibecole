package com.ibecole.ibecole.commun.enumerate;

public enum TypeExamen {

    EXAMENS("Examen"),
    INTEROGATION("Intérogation"),
    DEVOIR("Devoir");

    private String libelle;

    private TypeExamen(String libelle) {
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
