package com.example.projetfilrougejava.modele;

import java.util.Date;

public class FormCompte {
    private Date dateCreation;
    private Long partenaire;
    private String numCompte;
    private Integer solde ;
    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }



    public Long getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Long partenaire) {
        this.partenaire = partenaire;
    }



    public String getNumCompte() {
        return numCompte;
    }

    public Integer getSolde() {
        return solde;
    }

    public void setSolde(Integer solde) {
        this.solde = solde;
    }

    public void setNumCompte(String numCompte) {
        this.numCompte = numCompte;
    }
}
