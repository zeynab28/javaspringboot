package com.example.projetfilrougejava.modele;

import java.util.Date;

public class FormDepot {
    private Long montant;
    private Date dateDepot;
    private  String numbcompte;
    private Long user;

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public Date getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(Date dateDepot) {
        this.dateDepot = dateDepot;
    }

    public String getNumbcompte() {
        return numbcompte;
    }

    public void setNumbcompte(String numbcompte) {
        this.numbcompte = numbcompte;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }
}
