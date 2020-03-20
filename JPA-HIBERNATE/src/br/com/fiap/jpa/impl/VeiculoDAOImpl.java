package br.com.fiap.jpa.impl;

import br.com.fiap.jpa.dao.VeiculoDAO;
import br.com.fiap.jpa.entity.Veiculo;

public class VeiculoDAOImpl extends GenericDAOImpl<Veiculo,Integer> implements VeiculoDAO{

	public VeiculoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	

}
