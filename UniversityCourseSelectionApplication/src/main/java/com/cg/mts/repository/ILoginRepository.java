package com.cg.mts.repository;

import com.cg.mts.entities.Login;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ILoginRepository extends JpaRepository<Login, Integer>{

}
