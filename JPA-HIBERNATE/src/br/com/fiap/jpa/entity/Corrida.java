package br.com.fiap.jpa.entity;

import java.util.Calendar;

@Entity
@SequenceGenerator(name="run",sequenceName="SQ_T_CORRIDA",allocationSize=1)
@Table(name="T_CORRIDA")
public class Corrida {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "run")
	@Column(name="cd_corrida")
	private int codigo;
	
	@Column(name="ds_origem")
	private String partida;
	
	@Column(name="ds_destino")
	private String destino;
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_corrida")
	private Calendar data;
	
	@Column(name="",nullable=false)
	private double vlCorrida;

	public Corrida(int codigo, String partida, String destino, Calendar data, double vlCorrida) {
		super();
		this.codigo = codigo;
		this.partida = partida;
		this.destino = destino;
		this.data = data;
		this.vlCorrida = vlCorrida;
	}

	public Corrida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getPartida() {
		return partida;
	}

	public void setPartida(String partida) {
		this.partida = partida;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public double getVlCorrida() {
		return vlCorrida;
	}

	public void setVlCorrida(double vlCorrida) {
		this.vlCorrida = vlCorrida;
	}

}
