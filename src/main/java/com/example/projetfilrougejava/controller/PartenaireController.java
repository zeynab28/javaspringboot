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
            part.setNomComplet(partenair.getNomComplet());
            part.setRaisonSociale(partenair.getRaisonSociale());
            part.setAdresse(partenair.getAdresse());
            part.setTelephone(partenair.getTelephone());
            part.setEmail(partenair.getEmail());
            part.setStatut("actif");
        partenaireRepository.save(part);
            Compte compte=new Compte();
        SimpleDateFormat formater = new SimpleDateFormat("yyyyMMddhhmmss");
        Date now=new Date();
         compte.setNumCompte(partenair.getNumCompte());
         compte.setSolde(partenair.getSolde());//numcompte=formater.format(now);
         compte.setDateCreation(now);
        //part.setId(partenair.getPartenaire());
        compte.setPartenaire(part);
        compteRepository.save(compte);

        User user=new User();
        user.setUsername(partenair.getUsername());
        user.setPassword(passwordEncoder.encode(partenair.getPassword()));
        user.setAdresse(partenair.getAdresse());
        user.setEmail(partenair.getEmail());
        user.setName(partenair.getName());
        user.setStatut("actif");
        user.setTelephone(partenair.getTelephone());
        user.setPhoto(partenair.getPhoto());
        //compte.setId(partenair.getCompte());
        user.setCompte(compte);
        //part.setId(partenair.getPartenaire());
        user.setPartenaire(part);
        Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
                .orElseThrow(() -> new ApplicationContextException("User Role not set."));

        user.setRoles(Collections.singleton(userRole));

        userRepository.save(user);




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
