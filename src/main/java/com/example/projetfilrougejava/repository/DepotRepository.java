package com.example.projetfilrougejava.repository;


import com.example.projetfilrougejava.modele.Depot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepotRepository extends JpaRepository<Depot, Long> {
    //Optional<Compte> findByNumcompte(String compte);

}
