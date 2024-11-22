package com.projeto.integrador.model;
import com.projeto.integrador.dto.MedicoEditar;
import com.projeto.integrador.dto.MedicoReceber;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="medicos")
public class Medico {
	

	
	@Enumerated(EnumType.STRING)
	private Especialidade especialidade;
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String url_foto;
	private String crm;
	private String telefone;
	
	public Medico(MedicoReceber receber) {
		this.nome = receber.nome();
		this.crm = receber.crm();
		this.especialidade = receber.especialidade();
		this.url_foto = receber.url_foto();
		this.telefone = receber.telefone();
	}
	
	public Medico() {}	
	
	
	public String getTelefone() {
		return telefone;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getUrl_foto() {
		return url_foto;
	}
	public String getCrm() {
		return crm;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	
	
	public void atualizarDados(MedicoEditar dto_editar) {
		if(dto_editar.nome() != null) {this.nome = dto_editar.nome();}
		if(dto_editar.crm() != null) {this.crm = dto_editar.crm();}
		if(dto_editar.telefone() != null) {this.telefone = dto_editar.telefone();}
		if(dto_editar.url_foto() != null) {this.url_foto = dto_editar.url_foto();}
		if(dto_editar.especialidade() != null) {this.especialidade = dto_editar.especialidade();}
	};
	
	
	

}
