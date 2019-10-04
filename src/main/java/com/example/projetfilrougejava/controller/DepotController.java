package com.example.projetfilrougejava.controller;

import com.example.projetfilrougejava.modele.Compte;
import com.example.projetfilrougejava.modele.Depot;
import com.example.projetfilrougejava.modele.FormDepot;
import com.example.projetfilrougejava.modele.User;
import com.example.projetfilrougejava.repository.CompteRepository;
import com.example.projetfilrougejava.repository.DepotRepository;
import com.example.projetfilrougejava.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;

@RestController
@CrossOrigin
@RequestMapping("/depot")
public class DepotController {

    @Autowired
    DepotRepository depotRepository;
    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Autowired
    CompteRepository compteRepository;


    /**
     * @return depot
     */
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/ajouter", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> faireDepot(@RequestBody FormDepot dep) throws Exception{
        Depot depot = new Depot();
        if(dep.getMontant()<= 75000) {
            return new ResponseEntity( "Solde de depot doit etre supérieur à 75000 F CFA!",HttpStatus.OK);

        }
      /*  if(depot.getCompte()==null) {
           return  new ResponseEntity("Compte not found ",HttpStatus.OK);
        }*/
        /* if(depot.getUser()==null) {
            return new ResponseEntity( "UserConnect not found", HttpStatus.OK);
        }*/

        depot.setMontant(dep.getMontant());
        Date now = new Date();
        depot.setDateDepot(now);
        User user = userDetailsService.getUserConnect();
        depot.setUser(user);
        Compte compte = compteRepository.findCompteByNumCompte(dep.getNumbcompte()).orElseThrow(() -> new ApplicationContextException("Compte  not found."));
        compte.setSolde((int) (compte.getSolde()+dep.getMontant()));
        depotRepository.save(depot);

        return new ResponseEntity<>("depot effecteuer",HttpStatus.OK);


    }
}
