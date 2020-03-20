package br.com.fiap.jpa.entity;

import java.util.Calendar;

@Entity
@SequenceGenerator(name="pgto",sequenceName="SQ_T_PAGAMENTO",allocationSize=1)
@Table(name="T_PAGAMENTO")
public class Pagamento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pgto")
	@Column(name="cd_pagamento")
	private int codigo;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_pagamento",nullable=false)
	private Calendar dtPgto;
	
	@Column(name="vl_pagamento",nullable=false)
	private double salario;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_forma_pagamento",nullable=false)
	private FormaPgto formaPgto;

	public Pagamento(int codigo, Calendar dtPgto, double salario, FormaPgto formaPgto) {
		super();
		this.codigo = codigo;
		this.dtPgto = dtPgto;
		this.salario = salario;
		this.formaPgto = formaPgto;
	}

	public Pagamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Calendar getDtPgto() {
		return dtPgto;
	}

	public void setDtPgto(Calendar dtPgto) {
		this.dtPgto = dtPgto;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public FormaPgto getFormaPgto() {
		return formaPgto;
	}

	public void setFormaPgto(FormaPgto formaPgto) {
		this.formaPgto = formaPgto;
	}
}
