package com.projeto.integrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.integrador.model.Medico;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long>{

}
