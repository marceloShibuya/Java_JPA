package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(name="vei",sequenceName="SQ_T_VEICULO",allocationSize=1)
@Table(name="T_VEICULO")
public class Veiculo {
	
	@Id
	@GeneratedValue(generator="vei",strategy = GenerationType.SEQUENCE)
	@Column(name="cd_veiculo")
	private int codigo;
	
	@Column(name="ds_placa",nullable=false,length=9)
	private String placa;
	
	@Column(name="ds_cor",nullable=false,length=20)
	private String cor;
	
	@Temporal(TemporalType.DATE)
	@Column(name="nr_ano")
	private Calendar ano;

	public Veiculo(int codigo, String placa, String cor, Calendar ano) {
		super();
		this.codigo = codigo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
	}

	public Veiculo() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public Calendar getAno() {
		return ano;
	}

	public void setAno(Calendar ano) {
		this.ano = ano;
	}

}
