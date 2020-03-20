package br.com.fiap.jpa.entity;

import java.util.Calendar;

@Entity
@SequenceGenerator(name="pass",sequenceName="SQ_T_PASSAGEIRO",allocationSize=1)
@Table(name="T_PASSAGEIRO")
public class Passageiro {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pass")
	@Column(name="cd_passageiro")
	private int codigo;
	
	@Column(name="nm_passageiro",nullable=false,length=100)
	private String nome;
	
	@Temporal(TemporaType.DATE)
	@Column(name="dt_nascimento")
	private Calendar dtNascimento;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ds_genero")
	private Genero sexo;

	public Passageiro(int codigo, String nome, Calendar dtNascimento, Genero sexo) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.sexo = sexo;
	}

	public Passageiro() {
		super();
		// TODO Auto-generated constructor stub
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

	public Genero getSexo() {
		return sexo;
	}

	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}
	
	
	
}
