package com.joeladjidan.sanctityoflord.dto;


public enum TypeFichierEnum {
    EMISSION(1),
    GALERIE(2);

    private final int valeur;

    private TypeFichierEnum(Integer valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return this.valeur;
    }
}
