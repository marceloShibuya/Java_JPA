package br.com.fiap.jpa.impl;

import br.com.fiap.jpa.dao.PagamentoDAO;
import br.com.fiap.jpa.entity.Pagamento;

public class PagamentoDAOImpl extends GenericDAOImpl<Pagamento,Integer> implements PagamentoDAO{

	public PagamentoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}
	

}
