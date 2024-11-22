package com.projeto.integrador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.projeto.integrador.dto.MedicoEditar;
import com.projeto.integrador.dto.MedicoReceber;
import com.projeto.integrador.service.MedicoService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/")
public class MedicoController {
	
	@Autowired
	MedicoService service;
	
	@PostMapping("cadastrarmedicos")
	@Transactional
	public ResponseEntity<MedicoReceber> cadastrar(@RequestBody @Valid MedicoReceber receber){
		service.registrarMedico(receber);		
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	@Transactional
	public ResponseEntity<?> listar(){
		var medico = service.detalharMedico();
		return ResponseEntity.ok(medico);
	}
	
	@DeleteMapping
	public ResponseEntity<?> deletarMedico(Long id){		
		service.deletarMedico(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("{id}")
	public ResponseEntity<?> editarMedico(@PathVariable Long id, @RequestBody MedicoEditar editar){
		service.editarMedico(id, editar);
		return ResponseEntity.ok(service.detalharMedico());
		
	}
}