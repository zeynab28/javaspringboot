package com.example.projetfilrougejava.repository;


import com.example.projetfilrougejava.modele.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompteRepository extends JpaRepository<Compte, Long> {
    //Optional<Compte> findByNumcompte(String compte);

}
