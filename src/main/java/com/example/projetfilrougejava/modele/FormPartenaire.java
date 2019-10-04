package com.example.projetfilrougejava.modele;

import java.util.Date;

public class FormPartenaire {
    private String photo;
    private Date dateCreation;
    private Long partenaire;
    private String numCompte;
    private Integer solde ;
    private String name;
    private String username;
    private String email;
    private String emailp;
    private String password;
    private String telephone;
    private String telephonep;
    private String statut;
    private Long compte;
    private String adresse;
    private String adressep;
    private String ninea;
    private String nomComplet;
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }


    public String getStatutp() {
        return statutp;
    }

    public void setStatutp(String statutp) {
        this.statutp = statutp;
    }

    public String getEmailp() {
        return emailp;
    }

    public void setEmailp(String emailp) {
        this.emailp = emailp;
    }

    public String getTelephonep() {
        return telephonep;
    }

    public void setTelephonep(String telephonep) {
        this.telephonep = telephonep;
    }

    private String statutp;
    private  String raisonSociale;

    public String getAdressep() {
        return adressep;
    }

    public void setAdressep(String adressep) {
        this.adressep = adressep;
    }

    public FormPartenaire() {
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }


    public String getNinea() {
        return ninea;
    }

    public void setNinea(String ninea) {
        this.ninea = ninea;
    }


    public Integer getSolde() {
        return solde;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public Long getCompte() {
        return compte;
    }

    public void setCompte(Long compte) {
        this.compte = compte;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public Long getPartenaire() {
        return partenaire;
    }

    public String getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }

    public void setPartenaire(Long partenaire) {
        this.partenaire = partenaire;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }






}
