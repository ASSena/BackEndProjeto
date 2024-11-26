package com.projeto.integrador.dto;

import com.projeto.integrador.model.Especialidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record MedicoReceber(	
		
		@NotBlank
		String nome,
		
		String url_foto,
		
		@NotBlank
		@Pattern(regexp = "\\d{6,7}")
		String crm,
		
		@NotNull
		Especialidade especialidade,
		
		@NotBlank
		String telefone
		) {}
