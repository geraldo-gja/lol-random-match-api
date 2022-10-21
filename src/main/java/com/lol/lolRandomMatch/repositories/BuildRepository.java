package com.lol.lolRandomMatch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lol.lolRandomMatch.domain.Build;

@Repository
public interface BuildRepository extends JpaRepository<Build, Integer>{

}