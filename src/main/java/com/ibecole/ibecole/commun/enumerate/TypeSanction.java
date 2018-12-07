package com.ibecole.ibecole.commun.enumerate;

public enum TypeSanction {
    AVERTISSEMENT("Av", "Aertissement"),
    BLAME("Bl", "Blâme"),
    MESURE_RESPONSABILISATION("M.R", "Mesure de Responsabilisation"),
    EXCLUSION_TEMPORAIRE_CLASSE("E.T.C", "Exculusion Temporaire de la classe"),
    EXCLUSION_TEMPORAIRE_ETABLISSEMENT("E.T.E", "Exculusion Temporaire de l'établissement"),
    EXCLUSION_DEFINITIVE_ETABLISSEMENT("E.D.E", "Exculusion Définitive de l'établissement");

    private String code;
    private String libelle;

    private TypeSanction(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public String getCode() {
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
