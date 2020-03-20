package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_MOTORISTA")
public class Motorista {
	
	@Id
	@Column(name="nr_carteira")
	private int numeroCnh;
	
	@Column(name="nm_motorista",nullable=false,length=150)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dtNascimento;
	
	@Lob
	@Column(name="fl_carteira")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero",nullable=false)
	private Genero genero;

	public Motorista(int numeroCnh, String nome, Calendar dtNascimento, byte[] foto, Genero genero) {
		super();
		this.numeroCnh = numeroCnh;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.foto = foto;
		this.genero = genero;
	}

	public Motorista() {
		super();
	}

	public int getNumeroCnh() {
		return numeroCnh;
	}

	public void setNumeroCnh(int numeroCnh) {
		this.numeroCnh = numeroCnh;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

}
