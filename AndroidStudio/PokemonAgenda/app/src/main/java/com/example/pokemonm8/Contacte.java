package com.example.pokemonm8;

import android.net.Uri;

public class Contacte {
    private int id;
    private String nom;
    private String nTelefon;
    private Uri imagePFP;
    private Gender genere;
    private Team equip;

    public Contacte(int id, String nom, String nTelefon, Gender genere, Team equip) {
        this.id = id;
        this.nom = nom;
        this.nTelefon = nTelefon;
        this.genere = genere;
        this.equip = equip;
    }

    public Contacte(int id,String nom, String nTelefon, Uri imagePFP, Gender genere, Team equip) {
        this.id = id;
        this.nom = nom;
        this.nTelefon = nTelefon;
        this.imagePFP = imagePFP;
        this.genere = genere;
        this.equip = equip;
    }
//    public Contacte(String nom, String nTelefon, Gender genere, Team equip) {
//        this.nom = nom;
//        this.nTelefon = nTelefon;
//        this.genere = genere;
//        this.equip = equip;
//    }

//    public Contacte(String nom){
//        this.nom = nom;
//        this.nTelefon = "a673128837";
//        this.genere = Gender.DONA;
//        this.equip = Team.Valor;
//
//    }

    public String getNom(){
        return nom;
    }
    public String getnTelefon(){
        return nTelefon;
    }
    public Uri getImagePFP(){ return imagePFP;}
    public Gender getGenere() {
        return genere;
    }
    public Team getEquip() {
        return equip;
    }

    public int getId() {
        return id;
    }

    public void setNom(String n){
        this.nom=n;
    }
    public void setnTelefon(String n){
        this.nTelefon=n;
    }
    public void setImagePFP(Uri pfp){this.imagePFP=pfp;}
    public void setGenere(Gender genere) {
        this.genere = genere;
    }
    public void setEquip(Team equip) {
        this.equip = equip;
    }


    @Override
    public String toString() {
        return "Contacte{" +
                "nom='" + nom + '\'' +
                ", nTelefon='" + nTelefon + '\'' +
                ", imagePFP=" + imagePFP +
                ", genere=" + genere +
                ", equip=" + equip +
                '}';
    }
}