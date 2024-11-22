package com.projeto.integrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto.integrador.dto.MedicoEditar;
import com.projeto.integrador.dto.MedicoReceber;
import com.projeto.integrador.model.Medico;
import com.projeto.integrador.repository.MedicoRepository;



@Service
public class MedicoService {
	
	@Autowired
	private MedicoRepository repository;
	
	public List<Medico> detalharMedico(){
		return repository.findAll();
	}
	
	public void registrarMedico(MedicoReceber dto_medico_receber) {
		Medico medico = new Medico(dto_medico_receber);
		repository.save(medico);
	}
	
	public void editarMedico(Long id, MedicoEditar editar) {
		var medico = repository.getReferenceById(id);
		medico.atualizarDados(editar);
	}
	
	public void deletarMedico(Long id) {
		var medico = repository.getReferenceById(id);
		repository.delete(medico);
	}
	
}
