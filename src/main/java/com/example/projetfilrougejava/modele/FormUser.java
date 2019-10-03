package com.example.projetfilrougejava.modele;

public class FormUser {
    private Long id;
    private String name;
    private String username;
    private String email;
    private String password;
    private String telephone;
    private String statut;
    private String photo;
    private Long partenaire;
    private Long compte;

    public Long getPartenaire() {
        return partenaire;
    }

    public void setPartenaire(Long partenaire) {
        this.partenaire = partenaire;
    }

    public Long getCompte() {
        return compte;
    }

    public void setCompte(Long compte) {
        this.compte = compte;
    }

    public String getAdresse() {
        return adresse;
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

    public String getPassword() {
        return password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
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

    private  String adresse;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
