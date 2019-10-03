package com.example.projetfilrougejava.controller;


import com.example.projetfilrougejava.modele.Compte;
import com.example.projetfilrougejava.modele.FormUser;
import com.example.projetfilrougejava.modele.Partenaire;
import com.example.projetfilrougejava.modele.User;
import com.example.projetfilrougejava.repository.UserRepository;
import com.example.projetfilrougejava.services.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserRepository userRepository;

    @Autowired

    PasswordEncoder passwordEncoder;

    @Autowired
    UserDetailsServiceImpl userDetailsService;



    /**
     * lister les users
     */
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @GetMapping(value = "/lister")
    public List<User> liste(){
        return userRepository.findAll();
    }

    /**
     * consulter un user
     */

    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @GetMapping(value = "/lister/{id}")
    public Optional<User> listerOneUser(@PathVariable Long id){
        return  userRepository.findById(id);
    }


    /**
     * ajouter un user
     * @return
     */

    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PostMapping(value = "/ajouter",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User ajouterUser(@RequestBody FormUser form){

        User user=new User();
        user.setUsername(form.getUsername());
        user.setPassword(passwordEncoder.encode(form.getPassword()));
        user.setAdresse(form.getAdresse());
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setStatut(form.getStatut());
        user.setTelephone(form.getTelephone());
        user.setPhoto(form.getPhoto());

        Compte compte=new Compte();
        compte.setId(form.getCompte());
        user.setCompte(compte);
        Partenaire part=new Partenaire();
        part.setId(form.getPartenaire());
        user.setPartenaire(part);

        //User result = userRepository.save(u);

        //  return ResponseEntity.created().body("User registered successfully"));
        return  userRepository.save(user);
    }

    /**
     * ajouter un user
     * @return
     */

    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @PutMapping(value = "/ajouter/{id}",consumes = {MediaType.APPLICATION_JSON_VALUE})
    public User ajouterUser(@PathVariable Long id, @RequestBody User u){
        //sachant que l objet c ne contient pas l'id
        //on prend l id du path variable on le stocke dans u objet et on utilise directement c
        u.setId(id);
        u.setPassword(passwordEncoder.encode(u.getPassword()));

        //User result = userRepository.save(u);

        //  return ResponseEntity.created().body("User registered successfully"));
        return  userRepository.save(u);
    }

   /* @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    @GetMapping("/user/me")
    public User getCurrentUser(@PathVariable Long id, @RequestBody User u){
        //sachant que l objet c ne contient pas l'id
        //on prend l id du path variable on le stocke dans u objet et on utilise directement c
        u.setId(id);
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        //User result = userRepository.save(u);
        //  return ResponseEntity.created().body("User registered successfully"));
        return  userRepository.save(u);
    }
*/
    /**
     * ajouter compte
     */



}
