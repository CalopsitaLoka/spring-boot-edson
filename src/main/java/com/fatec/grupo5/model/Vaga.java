package com.fatec.grupo5.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Vaga {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotBlank(message = "Nome é requerido")
	private String nome;
	private String status;
	private String resumo;
	private float salario;
	@NotBlank(message = "Curso é requerido")
	private String curso;
	private String habilidades;
	
	public Vaga() {
	}
	
	public Vaga(String nome, String status, String resumo, float salario, String curso, String habilidades) {
		this.nome = nome;
		this.status = status;
		this.resumo = resumo;
		this.salario = salario;
		this.curso = curso;
		this.habilidades = habilidades;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getResumo() {
		return resumo;
	}
	
	public void setResumo(String resumo) {
		this.resumo = resumo;
	}
	
	public float getSalario() {
		return salario;
	}
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	public String getCurso() {
		return curso;
	}
	
	public void setCurso(String curso) {
		this.curso = curso;
	}
	
	public String getHabilidades() {
		return habilidades;
	}
	
	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}
}
