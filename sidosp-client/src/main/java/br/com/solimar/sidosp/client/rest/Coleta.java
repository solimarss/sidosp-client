package br.com.solimar.sidosp.client.rest;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlSchemaType;
//imports omitidos


public class Coleta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long numero;
	private Long doadorNum;
	private Long laboratorioNum;
	
	
	
	private Date data;
	private Date horario;
	private List<Exame> exames;
	

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Long getDoadorNum() {
		return doadorNum;
	}

	public void setDoadorNum(Long doadorNum) {
		this.doadorNum = doadorNum;
	}

	public Long getLaboratorioNum() {
		return laboratorioNum;
	}

	public void setLaboratorioNum(Long laboratorioNum) {
		this.laboratorioNum = laboratorioNum;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public List<Exame> getExames() {
		return exames;
	}

	public void setExames(List<Exame> exames) {
		this.exames = exames;
	}
	
}
