package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(sequenceName = "SQ_TB_ATOR", name="ator", allocationSize = 1)
@Table(name="TB_ATOR")
public class Ator {

	@Id
	@GeneratedValue(generator = "ator",strategy = GenerationType.SEQUENCE)
	@Column(name="cd_ator")
	private int codigo;
	
	@Column(name="nm_ator",nullable=false,length=50)
	private String nome;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dtNascimento;
	
	@Column(name="ds_altura")
	private float altura;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_area_atuacao")
	private Atuacao atuacao;

	public Ator() {
		super();
	}
	
	public Ator(String nome, Calendar dtNascimento, float altura, Atuacao atuacao) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.altura = altura;
		this.atuacao = atuacao;
	}

	public Ator(int codigo, String nome, Calendar dtNascimento, float altura, Atuacao atuacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.altura = altura;
		this.atuacao = atuacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public Atuacao getAtuacao() {
		return atuacao;
	}

	public void setAtuacao(Atuacao atuacao) {
		this.atuacao = atuacao;
	}
	
}
