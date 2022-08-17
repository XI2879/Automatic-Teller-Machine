package com.example.API.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.API.Entity.Player;

public interface PlayerRepository extends JpaRepository<Player,Integer> {

}
