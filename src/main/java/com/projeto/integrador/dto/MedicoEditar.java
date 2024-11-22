package com.projeto.integrador.dto;

import com.projeto.integrador.model.Especialidade;

import jakarta.validation.constraints.Pattern;

public record MedicoEditar(
		
		String nome,
		String url_foto,
		@Pattern(regexp = "\\d{6,7}")
		String crm,
		Especialidade especialidade,
		String telefone
		
		) {

}
