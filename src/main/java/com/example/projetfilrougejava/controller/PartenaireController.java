package com.example.projetfilrougejava.controller;


import com.example.projetfilrougejava.modele.*;
import com.example.projetfilrougejava.repository.CompteRepository;
import com.example.projetfilrougejava.repository.PartenaireRepository;
import com.example.projetfilrougejava.repository.RoleRepository;
import com.example.projetfilrougejava.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextException;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/partenaire")
public class PartenaireController {

    @Autowired
    PartenaireRepository partenaireRepository;
    @Autowired
    CompteRepository compteRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired

    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;

    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/ajouter",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void ajouterPartenaire(@RequestBody FormPartenaire partenair){
            Partenaire part=new Partenaire();
            part.setNinea(partenair.getNinea());
            part.getNomComplet(partenair.getNomComplet());
            part.getRaisonSociale(partenair.getRaisonSociale());
            part.getAdresse(partenair.getAdresse());
            part.getTelephone(partenair.getTelephone());

         /*partenaireRepository.save(partenaire);
         User user=new User();
         user.setAdresse(partenaire.getAdresse());*/

    }
    /**
     * lister les partenaires
     */
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @GetMapping(value = "/lister")
    public List<Partenaire> liste(){
        return partenaireRepository.findAll();
    }
}
