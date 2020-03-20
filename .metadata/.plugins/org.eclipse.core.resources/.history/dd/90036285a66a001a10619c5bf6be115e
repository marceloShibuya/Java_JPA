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
@SequenceGenerator(name="fil",sequenceName="SQ_TB_FILME",allocationSize=1)
@Table(name="TB_FILME")
public class Filme {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "fil")
	@Column(name="cd_filme")
	private int codigo;
	
	@Column(name="ds_titulo",nullable=false,length=50)
	private String titulo;
	
	@Column(name="ds_duracao")
	private int duracao;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_lancamento")
	private Calendar dtLancamento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_categoria")
	private Categoria categoria;

	
	public Filme() {
		super();
	}
	
	
	public Filme(String titulo, int duracao, Calendar dtLancamento, Categoria categoria) {
		super();
		this.titulo = titulo;
		this.duracao = duracao;
		this.dtLancamento = dtLancamento;
		this.categoria = categoria;
	}


	public Filme(int codigo, String titulo, int duracao, Calendar dtLancamento, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.duracao = duracao;
		this.dtLancamento = dtLancamento;
		this.categoria = categoria;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getDuracao() {
		return duracao;
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}


	public Calendar getDtLancamento() {
		return dtLancamento;
	}


	public void setDtLancamento(Calendar dtLancamento) {
		this.dtLancamento = dtLancamento;
	}


	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
}
