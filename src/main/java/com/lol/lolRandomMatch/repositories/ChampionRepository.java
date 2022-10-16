package com.lol.lolRandomMatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lol.lolRandomMatch.domain.Champion;

@Repository
public interface ChampionRepository extends JpaRepository<Champion, Integer>{

}
