package br.com.solimar.sidosp.client.rest;

import java.io.Serializable;

public class Exame implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long codigo;
	private String nome;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
