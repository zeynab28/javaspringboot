package com.example.projetfilrougejava.repository;


import com.example.projetfilrougejava.modele.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartenaireRepository extends JpaRepository<Partenaire, Long> {
    //Optional<Compte> findByNumcompte(String compte);

}
