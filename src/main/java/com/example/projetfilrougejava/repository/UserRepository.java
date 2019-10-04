package com.example.projetfilrougejava.repository;


import com.example.projetfilrougejava.modele.User;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

//se charge de la partie manip donnée
@Repository// dis a spring cree moi un objet et renvoi le moi avec Auto...
//c une interface sans implementation
public interface UserRepository extends JpaRepository<User, Long> {
    //le nom de la fonction compte
    //ex findByLoginAndPassword et on passe login et password en param
    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    User findUserById(Long id);
    //requete special
  /*  @Query("SELECT u FROM User u WHERE u.login IS NULL ")
    public List<User> users();*/

 /* @Query("select u from User u where u.telephone like :x")
    public Page<User> chercher(@Param("x")String)*/
}
