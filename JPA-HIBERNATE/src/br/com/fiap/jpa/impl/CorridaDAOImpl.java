package br.com.fiap.jpa.impl;

import br.com.fiap.jpa.dao.CorridaDAO;
import br.com.fiap.jpa.entity.Corrida;

public class CorridaDAOImpl extends GenericDAOImpl<Corrida,Integer> implements CorridaDAO{

	public CorridaDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
