package com.example.projetfilrougejava.controller;

import com.example.projetfilrougejava.modele.Compte;
import com.example.projetfilrougejava.modele.FormCompte;
import com.example.projetfilrougejava.modele.Partenaire;
import com.example.projetfilrougejava.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/compte")
public class CompteController {

    @Autowired
    CompteRepository compteRepository;


    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/ajouter",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Compte ajouterCompte(@RequestBody FormCompte formc){
        Compte compte=new Compte();
        compte.setDateCreation(formc.getDateCreation());
        compte.setSolde(formc.getSolde());
        compte.setNumCompte(formc.getNumCompte());
        Partenaire parte=new Partenaire();
        parte.setId(formc.getPartenaire());
        compte.setPartenaire(parte);

        return  compteRepository.save(compte);
    }
    /**
     * lister les partenaires
     */
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @GetMapping(value = "/lister")
    public List<Compte> liste(){
        return compteRepository.findAll();
    }


}
